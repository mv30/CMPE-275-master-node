import io.grpc.Server;
import io.grpc.ServerBuilder;
import service.ReplicationService;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class GrpcServer {

    private Server server;

    private void start() throws IOException {
        int port = 6090;
        server = ServerBuilder.forPort(port).addService( new ReplicationService()).build().start();

        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                System.out.println(" *** shutting down gRPC server since JVM is shutting down ");
                try {
                    GrpcServer.this.stop();
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

    private void stop() throws InterruptedException {
        if(server!=null) {
            server.shutdown().awaitTermination( 30, TimeUnit.SECONDS);
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException{

        GrpcServer server = new GrpcServer();
        server.start();
        System.out.println("Server started");
        server.blockUntilShutdown();
    }
}
