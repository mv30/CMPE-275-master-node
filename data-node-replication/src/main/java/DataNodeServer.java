import io.grpc.Server;
import io.grpc.ServerBuilder;
import service.DataNodeClient;
import service.DataNodeService;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

public class DataNodeServer {

    private Server server;

    private final Integer CLUSTER_SIZE;

    private final Integer BASE_PORT_NO;

    private final String DATA_FILE_PATH;

    private final Integer PORT_NO;

    private final Map<Integer, DataNodeClient> peers;

    public DataNodeServer( Integer CLUSTER_SIZE, String DATA_FILE_PATH, Integer PORT_NO) {
        this.BASE_PORT_NO = 6090;
        this.CLUSTER_SIZE = CLUSTER_SIZE;
        this.DATA_FILE_PATH = DATA_FILE_PATH;
        this.PORT_NO = BASE_PORT_NO + PORT_NO;
        this.peers = new TreeMap<>();
        for( int i=0; i<this.CLUSTER_SIZE; i++) {
            peers.put(BASE_PORT_NO + (i+PORT_NO)%CLUSTER_SIZE, new DataNodeClient());
        }
    }

    public List<DataNodeClient> getActivePeers() {

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
        server = ServerBuilder.forPort(this.PORT_NO).addService(new DataNodeService(this.DATA_FILE_PATH)).build().start();
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
        Integer CLUSTER_SIZE = 5;
        Integer PORT_NO = 0;
        String dataFilePath = "";
        DataNodeServer dataNodeServer = new DataNodeServer( CLUSTER_SIZE, dataFilePath, PORT_NO);
        dataNodeServer.start();
        System.out.println("Server UP");
        dataNodeServer.blockUntilShutdown();
    }
}
