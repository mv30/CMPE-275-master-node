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
        peers.remove(serverId);
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
        Integer replicationNode = hostServerId;
        try {
            if(hostServerId==-1) {
                replicationNode = findReplicationNode(getNodeForDownloadRequest.getFilename());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        IpDetailsEntry ipDetailsEntry = peers.get(replicationNode);
        return ipDetailsEntry.getMasterCommDataNodeClient().getNodeForDownload(getNodeForDownloadRequest);
    }

    public GetNodeForUploadResponse getNodeForUpload( GetNodeForUploadRequest getNodeForUploadRequest) {
        List<Integer> activeDataNodeServerIds = new ArrayList<>(peers.keySet());
        Collections.shuffle(activeDataNodeServerIds);
        Integer dateNodeServerId = activeDataNodeServerIds.get(0);
        IpDetailsEntry ipDetailsEntry = peers.get(dateNodeServerId);
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
        Integer replicationNode = hostServerId;
        try {
            if(hostServerId==-1) {
                replicationNode = findReplicationNode(nodeIpsRequest.getFilename());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        IpDetailsEntry ipDetailsEntry = peers.get(replicationNode);
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

    public static void main(String[] args) throws Exception {

        MasterCommMonitorService masterCommMonitorService = new MasterCommMonitorService(-1);
//        System.out.println(" Testing set data ");
//        masterCommMonitorService.setData(DataPayload
//                .newBuilder()
//                .setKey("cars")
//                .addAllValues(Arrays.asList("BMW", "Lexus", "Tesla")).build());
//        masterCommMonitorService.setData(DataPayload
//                .newBuilder()
//                .setKey("trucks")
//                .addAllValues(Arrays.asList("Tahoe", "GMD", "Mahindra", "BMW")).build());
//        masterCommMonitorService.setData(DataPayload
//                .newBuilder()
//                .setKey("bikes")
//                .addAllValues(Arrays.asList("Ninja", "Y2k", "Duke KTM")).build());
//        masterCommMonitorService.setData(DataPayload
//                .newBuilder()
//                .setKey("cars-1")
//                .addAllValues(Arrays.asList("BMW", "Lexus", "Tesla")).build());
//        masterCommMonitorService.setData(DataPayload
//                .newBuilder()
//                .setKey("trucks-1")
//                .addAllValues(Arrays.asList("Tahoe", "GMD", "Mahindra", "BMW")).build());
//        masterCommMonitorService.setData(DataPayload
//                .newBuilder()
//                .setKey("bikes-1")
//                .addAllValues(Arrays.asList("Ninja", "Y2k", "Duke KTM")).build());
//        System.out.println(" Testing get data ");
//        System.out.println(masterCommMonitorService.getData(
//                DataPayload.newBuilder()
//                        .setKey("cars").build()
//        ));
//        System.out.println(masterCommMonitorService.getData(
//                DataPayload.newBuilder()
//                        .setKey("trucks").build()
//        ));
//        System.out.println(masterCommMonitorService.getData(
//                DataPayload.newBuilder()
//                        .setKey("bikes").build()
//        ));
//        System.out.println(" Testing remove data ");
//        System.out.println(masterCommMonitorService.removeData(
//                DataPayload.newBuilder()
//                        .setKey("bikes").build()
//        ));
//        System.out.println(" Testing new node update ");
//        System.out.println(masterCommMonitorService
//                .newNodeUpdate(NewNodeUpdateRequest
//                .newBuilder()
//                .setNewnodeip("AWS")
//                .build()));
//        System.out.println(masterCommMonitorService
//                .newNodeUpdate(NewNodeUpdateRequest
//                        .newBuilder()
//                        .setNewnodeip("Azure")
//                        .build()));
//        System.out.println(masterCommMonitorService
//                .newNodeUpdate(NewNodeUpdateRequest
//                        .newBuilder()
//                        .setNewnodeip("GCP")
//                        .build()));
//        System.out.println(" get node for download ");
//        System.out.println(masterCommMonitorService
//                .getNodeForDownload(
//                        GetNodeForDownloadRequest
//                        .newBuilder()
//                        .setFilename("cars")
//                        .build()));
//        System.out.println(" get node for upload ");
//        System.out.println(masterCommMonitorService
//                .getNodeForUpload(GetNodeForUploadRequest
//                        .newBuilder()
//                        .setFilename("colours")
//                        .build()));
//        System.out.println(" node down update ");
//        System.out.println(masterCommMonitorService
//                .nodeDownUpdate(NodeDownUpdateRequest
//                        .newBuilder()
//                        .setNodeip("AWS")
//                        .build()));
//        System.out.println(" get node ips for replication");
//        System.out.println(masterCommMonitorService.getNodeIpsForReplication(NodeIpsRequest.newBuilder().setFilename("cars").build()));
//        System.out.println(" update replication status ");
//        System.out.println(masterCommMonitorService.updateReplicationStatus(ReplicationDetailsRequest.newBuilder().setFilename("cars").addAllNodeips(Arrays.asList("Audi", "Polo")).build()));
//        System.out.println(masterCommMonitorService.getNodeIpsForReplication(NodeIpsRequest.newBuilder().setFilename("cars").build()));
//        System.out.println(" get list of all files ");
//        System.out.println(masterCommMonitorService.getListOfFiles(GetListOfFilesRequest.newBuilder().addAllNodeips(Arrays.asList("BMW")).build()));
    }
}
