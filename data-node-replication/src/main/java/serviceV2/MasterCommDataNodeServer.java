package serviceV2;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.util.concurrent.TimeUnit;

public class MasterCommDataNodeServer {

    private Integer hostServerId;

    private String hostName;

    private Integer portNo;

    private Server server;

    private String keyValueFilePath;

    private String activeNodeFilePath;

    private MasterCommMonitorService masterCommMonitorService;

    public MasterCommDataNodeServer( Integer hostServerId) {
        this.hostServerId = hostServerId;
        this.masterCommMonitorService = new MasterCommMonitorService(this.hostServerId);
        this.hostName = masterCommMonitorService.getPeers().get(hostServerId).getHostName();
        this.portNo = masterCommMonitorService.getPeers().get(hostServerId).getPortNo();
        this.keyValueFilePath = masterCommMonitorService.getPeers().get(hostServerId).getKeyValueFilePath();
        this.activeNodeFilePath = masterCommMonitorService.getPeers().get(hostServerId).getActiveNodesFilePath();
    }

    private void startServer() throws Exception {
        server = ServerBuilder
                .forPort(this.portNo)
                .addService(new MasterCommDataNodeServerImpl( this.keyValueFilePath, this.activeNodeFilePath))
                .build();
        server.start();
        new MasterCommFaultToleranceService(hostServerId, this.masterCommMonitorService).start();
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                System.out.println(" *** shutting down gRPC server since JVM is shutting down ");
                try {
                    stopServer();
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("*** server shut down");
            }
        });
    }

    private void blockUntilShutdown() throws InterruptedException {
        if(server!=null) {
            server.awaitTermination();
        }
    }

    private void stopServer() throws InterruptedException {
        if(server!=null) {
            server.shutdown().awaitTermination( 30, TimeUnit.SECONDS);
        }
    }

    public static void main(String[] args) throws Exception {
        /*
        * Make it a cmd line arguement
        * */
        Integer serverId = 1;
        MasterCommDataNodeServer masterCommDataNodeServer = new MasterCommDataNodeServer(serverId);
        masterCommDataNodeServer.startServer();
        System.out.println("Server UP");
        masterCommDataNodeServer.blockUntilShutdown();
    }
}
