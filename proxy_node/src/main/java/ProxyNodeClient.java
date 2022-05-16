import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.master.protos.GetNodeForUploadRequest;
import org.master.protos.GetNodeForUploadResponse;
import org.master.protos.ReplicationGrpc;

public class ProxyNodeClient {

    private final String SERVER_IP;

    private final Integer SERVER_PORT_NO;

    private final ReplicationGrpc.ReplicationBlockingStub replicationBlockingStub;


    public ProxyNodeClient(String SERVER_IP, Integer SERVER_PORT_NO) {
        this.SERVER_IP = SERVER_IP;
        this.SERVER_PORT_NO = SERVER_PORT_NO;
        ManagedChannel managedChannel = ManagedChannelBuilder.forTarget(String.format("%s:%s", this.SERVER_IP, this.SERVER_PORT_NO)).usePlaintext().build();
        replicationBlockingStub = ReplicationGrpc.newBlockingStub(managedChannel);
    }

    public void getNode( String filename, long filesize) {
        GetNodeForUploadResponse response = replicationBlockingStub.getNodeForUpload(GetNodeForUploadRequest.newBuilder().
                setFilename(filename).setFilesize(filesize).build());
        System.out.println(response.getNodeip());
    }

    public static void main(String[] args) {
        /*
        *   Testing
        * */
        ProxyNodeClient client = new ProxyNodeClient( "localhost", 6090);
        client.getNode("file1.txt", 1234);
    }
}
