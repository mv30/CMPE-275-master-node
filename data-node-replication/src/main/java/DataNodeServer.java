import entry.IpDetailsEntry;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import service.DataNodeDbService;
import service.FaultToleranceService;
import service.MonitorService;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class DataNodeServer {

    private final Integer serverId;

   private final MonitorService monitorService;

   private Server server;

    public DataNodeServer( Integer serverId) {
        this.serverId = serverId;
        this.monitorService = new MonitorService(serverId);
        new FaultToleranceService( serverId, monitorService).start();
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

    private void start() throws IOException {
        IpDetailsEntry ipDetailsEntry = monitorService.getPeerInfo(serverId);
        server = ServerBuilder.forPort(ipDetailsEntry.getPortNo()).addService(new DataNodeDbService(ipDetailsEntry.getFilePath())).build().start();
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

    public static void main(String[] args) throws Exception {
        Integer serverId = 1;
        DataNodeServer dataNodeServer = new DataNodeServer(serverId);
        dataNodeServer.start();
        System.out.println("Server UP");
        dataNodeServer.blockUntilShutdown();
    }
}
