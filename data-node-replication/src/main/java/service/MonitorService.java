package service;

import entry.IpDetailsEntry;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class MonitorService {

    private final Integer hostServerId;

    private final Map<Integer, IpDetailsEntry> dataNodePeers;

    public MonitorService( Integer hostServerId) {
        if (hostServerId==null) {
            hostServerId = -1;
        }
        this.hostServerId = hostServerId;
        this.dataNodePeers = new HashMap<>();
        this.dataNodePeers.put( 1, new IpDetailsEntry( "localhost", 6091, "/Users/mayankverma/replicated-data/replication-1"));
        this.dataNodePeers.put( 2, new IpDetailsEntry( "localhost", 6092, "/Users/mayankverma/replicated-data/replication-2"));
        this.dataNodePeers.put( 3, new IpDetailsEntry( "localhost", 6093, "/Users/mayankverma/replicated-data/replication-3"));
    }

    public Integer getHostServerId() {
        return this.hostServerId;
    }

    public Set<Integer> getAllServerIds() {
        return new HashSet<>(this.dataNodePeers.keySet());
    }

    public Integer getPeerSize() {
        return this.dataNodePeers.size();
    }

    public IpDetailsEntry removePeer(Integer serverIdToRemove) {
        IpDetailsEntry ipDetailsEntry = this.dataNodePeers.get(serverIdToRemove);
        this.dataNodePeers.remove(serverIdToRemove);
        return ipDetailsEntry;
    }

    public IpDetailsEntry getPeerInfo( Integer serverId) {
        return dataNodePeers.get(serverId);
    }

    public Set<Integer> getInactivePeers() {
        Set<Integer> inactiveServerIds = new HashSet<>();
        for(Integer peerServerId: dataNodePeers.keySet()) {
            if(peerServerId==this.hostServerId) {
                continue;
            }
            IpDetailsEntry ipDetailsEntry = dataNodePeers.get(peerServerId);
            try {
                DataNodeClient dataNodeClient = ipDetailsEntry.getDataNodeClient();
                dataNodeClient.healthPoll();
            } catch (Exception e) {
                e.printStackTrace();
                inactiveServerIds.add(peerServerId);
            }
        }
        return inactiveServerIds;
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
        List<Integer> activeServerNodeIds = new ArrayList<>(dataNodePeers.keySet());
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
        List<Integer> activeServerNodeIds = new ArrayList<>(dataNodePeers.keySet());
        Integer masterNodeId = findMasterNode( str, activeServerNodeIds);
        Integer id = activeServerNodeIds.indexOf(masterNodeId);
        id = (id+1)%activeServerNodeIds.size();
        return activeServerNodeIds.get(id);
    }

    public static void main(String[] args) throws Exception {

        MonitorService monitorService = new MonitorService(-1);

        Map<String, String> hm = new HashMap<>();
        for( int i=0; i<10; i++) {
            String key = String.format("key-%s",i);
            String value = String.format("value-%s",i);
            Integer masterNodeId = monitorService.findMasterNode(key);
            Integer replicationNodeId = monitorService.findReplicationNode(key);
            System.out.println(String.format(" key: %s masterNodeId:%s replication:%s", key, masterNodeId, replicationNodeId));
            monitorService.getPeerInfo(masterNodeId).getDataNodeClient().set(key, value);
        }
    }
}
