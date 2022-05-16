package service;

import java.util.Set;

public class ProxyMasterFaultToleranceService extends Thread{

    private MasterCommMonitorService masterCommMonitorService;


    public ProxyMasterFaultToleranceService( MasterCommMonitorService masterCommMonitorService) {
        this.masterCommMonitorService = masterCommMonitorService;
    }

    public void removeUnhealthyNodes() throws Exception{
        Set<Integer> faultyServerIds = masterCommMonitorService.getInactivePeers();
        if(faultyServerIds.isEmpty()) {
            return;
        }
        for(Integer faultServerId: faultyServerIds) {
            System.out.println(String.format(" found & removed serverId: %s faulty from group of %s", faultServerId));
            masterCommMonitorService.removePeer(faultServerId);
        }
    }

    @Override
    public void run() {
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
                    removeUnhealthyNodes();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
