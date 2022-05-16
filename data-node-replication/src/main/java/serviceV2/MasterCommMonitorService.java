package serviceV2;

import entryV2.IpDetailsEntry;
import lombok.Getter;
import lombok.Setter;
import org.master.protos.*;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

@Getter
@Setter
public class MasterCommMonitorService {

    private Integer hostServerId;

    private Map<Integer, IpDetailsEntry> peers;

    public MasterCommMonitorService( Integer hostServerId) {
        this.hostServerId = hostServerId;
        this.peers = new HashMap<>();
        this.peers.put( 1, new IpDetailsEntry("localhost", 6091, "/Users/mayankverma/replicated-data/replication-1/data.json", "/Users/mayankverma/replicated-data/replication-1/servers.json"));
        this.peers.put( 2, new IpDetailsEntry("localhost", 6092, "/Users/mayankverma/replicated-data/replication-2/data.json", "/Users/mayankverma/replicated-data/replication-2/servers.json"));
        this.peers.put( 3, new IpDetailsEntry("localhost", 6093, "/Users/mayankverma/replicated-data/replication-3/data.json", "/Users/mayankverma/replicated-data/replication-3/servers.json"));
    }

    public IpDetailsEntry removePeer( Integer serverId) {
        IpDetailsEntry ipDetailsEntry = peers.get(serverId);
        return ipDetailsEntry;
    }

    public Set<Integer> getInactivePeers() {
        Set<Integer> inactivePeerServerIds = new HashSet<>();
        for(Map.Entry<Integer, IpDetailsEntry> entry: peers.entrySet()) {
            Integer serverId = entry.getKey();
            IpDetailsEntry ipDetailsEntry = entry.getValue();
            if(serverId==hostServerId) {
                continue;
            }
            try {
                ipDetailsEntry.getMasterCommDataNodeClient().healthPoll(DataPayload.newBuilder().build());
            } catch (Exception e) {
                inactivePeerServerIds.add(serverId);
            }
        }
        return inactivePeerServerIds;
    }

    public DataPayload setData(DataPayload dataPayload) throws Exception {
        DataPayload dataPayloadResponse = null;
        String key = dataPayload.getKey();
        Set<Integer> targetNodeServerIds = new HashSet<>(Arrays.asList(
                findMasterNode(key),
                findReplicationNode(key)
        ));
        for(Map.Entry<Integer, IpDetailsEntry> entry: peers.entrySet()) {
            Integer serverId = entry.getKey();
            IpDetailsEntry ipDetailsEntry = entry.getValue();
            if(targetNodeServerIds.contains(serverId)) {
                dataPayloadResponse = ipDetailsEntry.getMasterCommDataNodeClient().setData(dataPayload);
            }
        }
        return dataPayloadResponse;
    }

    public DataPayload getData(DataPayload dataPayload) throws Exception {
        DataPayload dataPayloadResponse = null;
        String key = dataPayload.getKey();
        Set<Integer> targetNodeServerIds = new HashSet<>(Arrays.asList(
                findReplicationNode(key)
        ));
        for(Map.Entry<Integer, IpDetailsEntry> entry: peers.entrySet()) {
            Integer serverId = entry.getKey();
            IpDetailsEntry ipDetailsEntry = entry.getValue();
            if(targetNodeServerIds.contains(serverId)) {
                dataPayloadResponse = ipDetailsEntry.getMasterCommDataNodeClient().getData(dataPayload);
            }
        }
        return dataPayloadResponse;
    }

    public DataPayload removeData(DataPayload dataPayload) throws Exception {
        DataPayload dataPayloadResponse = null;
        String key = dataPayload.getKey();
        Set<Integer> targetNodeServerIds = new HashSet<>(Arrays.asList(
                findMasterNode(key),
                findReplicationNode(key)
        ));
        for(Map.Entry<Integer, IpDetailsEntry> entry: peers.entrySet()) {
            Integer serverId = entry.getKey();
            IpDetailsEntry ipDetailsEntry = entry.getValue();
            if(targetNodeServerIds.contains(serverId)) {
                dataPayloadResponse = ipDetailsEntry.getMasterCommDataNodeClient().removeData(dataPayload);
            }
        }
        return dataPayloadResponse;

    }

    public StatusResponse newNodeUpdate(NewNodeUpdateRequest newNodeUpdateRequest) {
        for(Map.Entry<Integer, IpDetailsEntry> entry: peers.entrySet()) {
            IpDetailsEntry ipDetailsEntry = entry.getValue();
            ipDetailsEntry.getMasterCommDataNodeClient().newNodeUpdate(newNodeUpdateRequest);
        }
        return StatusResponse.newBuilder().setStatus(Status.SUCCESS).build();
    }

    public GetNodeForDownloadResponse getNodeForDownload(GetNodeForDownloadRequest getNodeForDownloadRequest) {
        IpDetailsEntry ipDetailsEntry = peers.get(hostServerId);
        return ipDetailsEntry.getMasterCommDataNodeClient().getNodeForDownload(getNodeForDownloadRequest);
    }

    public GetNodeForUploadResponse getNodeForUpload( GetNodeForUploadRequest getNodeForUploadRequest) {
        IpDetailsEntry ipDetailsEntry = peers.get(hostServerId);
        return ipDetailsEntry.getMasterCommDataNodeClient().getNodeForUpload(getNodeForUploadRequest);
    }

    public StatusResponse nodeDownUpdate(NodeDownUpdateRequest nodeDownUpdateRequest) {
        for(Map.Entry<Integer, IpDetailsEntry> entry: peers.entrySet()) {
            IpDetailsEntry ipDetailsEntry = entry.getValue();
            ipDetailsEntry.getMasterCommDataNodeClient().nodeDownUpdate(nodeDownUpdateRequest);
        }
        return StatusResponse.newBuilder().setStatus(Status.SUCCESS).build();
    }

    public NodeIpsReply getNodeIpsForReplication(NodeIpsRequest nodeIpsRequest) {
        IpDetailsEntry ipDetailsEntry = peers.get(hostServerId);
        return ipDetailsEntry.getMasterCommDataNodeClient().getNodeIpsForReplication(nodeIpsRequest);
    }

    public ReplicationDetailsResponse updateReplicationStatus(ReplicationDetailsRequest replicationDetailsRequest) throws Exception {
        ReplicationDetailsResponse replicationDetailsResponse = null;
        String key = replicationDetailsRequest.getFilename();
        Set<Integer> targetNodeServerIds = new HashSet<>(Arrays.asList(
                findMasterNode(key),
                findReplicationNode(key)
        ));
        for(Map.Entry<Integer, IpDetailsEntry> entry: peers.entrySet()) {
            Integer serverId = entry.getKey();
            IpDetailsEntry ipDetailsEntry = entry.getValue();
            if(targetNodeServerIds.contains(serverId)) {
                replicationDetailsResponse = ipDetailsEntry.getMasterCommDataNodeClient().updateReplicationStatus(replicationDetailsRequest);
            }
        }
        return replicationDetailsResponse;
    }

    public GetListOfFilesResponse getListOfFiles(GetListOfFilesRequest getListOfFilesRequest) {
        Set<String> fileNamesSet = new HashSet<>();
        for(Map.Entry<Integer, IpDetailsEntry> entry: peers.entrySet()) {
            Integer serverId = entry.getKey();
            IpDetailsEntry ipDetailsEntry = entry.getValue();
            GetListOfFilesResponse getListOfFilesResponse = ipDetailsEntry.getMasterCommDataNodeClient().getListOfFiles(getListOfFilesRequest);
            fileNamesSet.addAll(getListOfFilesResponse.getFilenamesList());
        }
        return GetListOfFilesResponse.newBuilder().addAllFilenames(fileNamesSet).build();
    }

    private String convertToHex(final byte[] messageDigest) {
        BigInteger bigint = new BigInteger(1, messageDigest);
        String hex = bigint.toString(16);
        while (hex.length() < 32) {
            hex = "0".concat(hex);
        }
        return hex;
    }

    public String createHash(String input) throws NoSuchAlgorithmException {
        String hashString = null;
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] messageDigest = md.digest(input.getBytes());
        hashString = convertToHex(messageDigest);
        return hashString;
    }

    public int findMasterNode( String str, List<Integer> activeServerNodeIds) throws NoSuchAlgorithmException {
        Integer totalNumberOfNodes = activeServerNodeIds.size();
        String hashString = createHash(str);
        BigInteger decimal = new BigInteger(hashString, 16);
        int node = decimal.mod(BigInteger.valueOf(Long.valueOf(totalNumberOfNodes))).intValue();
        return activeServerNodeIds.get(node);
    }

    public int findMasterNode( String str) throws NoSuchAlgorithmException {
        List<Integer> activeServerNodeIds = new ArrayList<>(peers.keySet());
        Integer totalNumberOfNodes = activeServerNodeIds.size();
        String hashString = createHash(str);
        BigInteger decimal = new BigInteger(hashString, 16);
        int node = decimal.mod(BigInteger.valueOf(Long.valueOf(totalNumberOfNodes))).intValue();
        return activeServerNodeIds.get(node);
    }

    public int findReplicationNode( String str, List<Integer> activeServerNodeIds) throws NoSuchAlgorithmException {
        Integer masterNodeId = findMasterNode( str, activeServerNodeIds);
        Integer id = activeServerNodeIds.indexOf(masterNodeId);
        id = (id+1)%activeServerNodeIds.size();
        return activeServerNodeIds.get(id);
    }

    public int findReplicationNode( String str) throws NoSuchAlgorithmException {
        List<Integer> activeServerNodeIds = new ArrayList<>(peers.keySet());
        Integer replicationNodeId = findReplicationNode( str, activeServerNodeIds);
        Integer id = activeServerNodeIds.indexOf(replicationNodeId);
        id = (id+1)%activeServerNodeIds.size();
        return activeServerNodeIds.get(id);
    }
}
