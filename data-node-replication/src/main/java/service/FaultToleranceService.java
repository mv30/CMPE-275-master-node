package service;

import com.google.common.collect.Sets;
import entry.IpDetailsEntry;

import java.util.*;

public class FaultToleranceService extends Thread {

    private final Integer serverId;

    private final MonitorService monitorService;

    private final FileHandler fileHandler;

    public FaultToleranceService( Integer serverId, MonitorService monitorService) {
        this.serverId = serverId;
        this.monitorService = monitorService;
        IpDetailsEntry ipDetailsEntry = monitorService.getPeerInfo(serverId);
        this.fileHandler = new FileHandler(ipDetailsEntry.getFilePath());
    }

    public void redistributeExistingData() throws Exception {
        Set<Integer> faultyServerIds = monitorService.getInactivePeers();
        if(faultyServerIds.isEmpty()) {
            return;
        }
        List<Integer> activeServerNodes = new ArrayList<>(Sets.difference( new HashSet<>(monitorService.getAllServerIds()), faultyServerIds));
        Collections.sort(activeServerNodes);
        for(Integer faultServerId: faultyServerIds) {
            System.out.println(String.format(" found serverId: %s faulty ", faultServerId));
            monitorService.removePeer(faultServerId);
        }
        List<DataEntry> dataEntryList = fileHandler.getFileContent();
        for(DataEntry dataEntry: dataEntryList) {
           Integer entryMasterNode = monitorService.findMasterNode(dataEntry.getKey(), activeServerNodes);
           if(!entryMasterNode.equals(serverId)) {
               fileHandler.remove(dataEntry.getKey());
           }
        }
        Thread.sleep(5000);
        for(DataEntry dataEntry: dataEntryList) {
            Integer entryMasterNode = monitorService.findMasterNode(dataEntry.getKey(), activeServerNodes);
            if(entryMasterNode.equals(serverId)) {
                Integer entryReplicationNode = monitorService.findReplicationNode(dataEntry.getKey(), activeServerNodes);
                DataNodeClient dataNodeClient = monitorService.getPeerInfo(entryReplicationNode).getDataNodeClient();
                dataNodeClient.set(dataEntry.getKey(), dataEntry.getValue());
            }
        }
    }

    @Override
    public void run() {
        System.out.println(String.format(" %s is monitoring other nodes ", serverId));
        try {
            Thread.sleep(10000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        while(true) {
            Set<Integer> inactivePeers = monitorService.getInactivePeers();
            if(inactivePeers.isEmpty()) {
                try {
                    System.out.println(" Everything healthy ");
                    Thread.sleep(5000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    redistributeExistingData();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
