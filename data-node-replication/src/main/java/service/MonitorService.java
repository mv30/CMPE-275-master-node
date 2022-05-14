package service;

import entry.IpDetailsEntry;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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

}
