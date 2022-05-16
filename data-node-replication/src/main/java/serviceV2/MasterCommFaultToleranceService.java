package serviceV2;


import org.master.protos.DataPayload;
import service.DataNodeClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MasterCommFaultToleranceService extends Thread{

    private Integer hostServerId;

    private MasterCommMonitorService masterCommMonitorService;

    private FileHandler keyValueFileHandler;

    public MasterCommFaultToleranceService( Integer hostServerId, MasterCommMonitorService masterCommMonitorService) {
        this.hostServerId = hostServerId;
        this.masterCommMonitorService = masterCommMonitorService;
        this.keyValueFileHandler = new FileHandler(masterCommMonitorService.getPeers().get(hostServerId).getKeyValueFilePath());
    }

    public void redistributeExistingData() throws Exception{
        Set<Integer> faultyServerIds = masterCommMonitorService.getInactivePeers();
        if(faultyServerIds.isEmpty()) {
            return;
        }
        for(Integer faultServerId: faultyServerIds) {
            System.out.println(String.format(" found serverId: %s faulty ", faultServerId));
            masterCommMonitorService.removePeer(faultServerId);
        }
        List<DataEntry> dataEntryList = keyValueFileHandler.getFileContent();
        List<Integer> activeServerNodes = new ArrayList<>(masterCommMonitorService.getPeers().keySet());
        for(DataEntry dataEntry: dataEntryList) {
            Integer entryMasterNode = masterCommMonitorService.findMasterNode(dataEntry.getKey(), activeServerNodes);
            if(!entryMasterNode.equals(hostServerId)) {
                keyValueFileHandler.remove(dataEntry.getKey());
            }
        }
        /*
        * Allows threads to synchronize after removal
        * */
        Thread.sleep(5000);
        for(DataEntry dataEntry: dataEntryList) {
            Integer entryMasterNode = masterCommMonitorService.findMasterNode(dataEntry.getKey(), activeServerNodes);
            if(entryMasterNode.equals(hostServerId)) {
                Integer entryReplicationNode = masterCommMonitorService.findReplicationNode(dataEntry.getKey(), activeServerNodes);
                MasterCommDataNodeClient masterCommDataNodeClient = masterCommMonitorService.getPeers().get(entryReplicationNode).getMasterCommDataNodeClient();
                masterCommDataNodeClient.setData(DataPayload.newBuilder().setKey(dataEntry.getKey()).addAllValues(dataEntry.getValues()).build());
            }
        }
    }

    @Override
    public void run() {
        try {
            // TODO: replace with flag
            Thread.sleep(60000);
        }catch (Exception e) {
            throw  new RuntimeException(e);
        }
        while (true) {
            Set<Integer> inactivePeers = masterCommMonitorService.getInactivePeers();
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