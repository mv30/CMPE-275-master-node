import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.master.protos.*;

import java.util.Arrays;
import java.util.List;

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

    public void addNewNode(String nodeIp) {
        StatusResponse response = replicationBlockingStub.newNodeUpdate(NewNodeUpdateRequest.newBuilder().
                setNewnodeip(nodeIp).build());
        System.out.println(response.getStatus());
    }

    public String getNodeForUpload(String filename, long filesize) {
        GetNodeForUploadResponse response = replicationBlockingStub.getNodeForUpload(GetNodeForUploadRequest.newBuilder().
                setFilename(filename).setFilesize(filesize).build());
        System.out.println(response.getNodeip());
        return response.getNodeip();
    }

    public String getNodeForDownload(String filename) {
        GetNodeForDownloadResponse response = replicationBlockingStub.getNodeForDownload(GetNodeForDownloadRequest.newBuilder().
                setFilename(filename).build());
        System.out.println(response.getNodeip());
        return response.getNodeip();
    }

    public void getNodeDownUpdate(String nodeIp) {
        StatusResponse response = replicationBlockingStub.nodeDownUpdate(NodeDownUpdateRequest.newBuilder().
                setNodeip(nodeIp).build());
        System.out.println(response.getStatus());
    }

    public void getNodeIpsForReplication(String filename) {
        NodeIpsReply response = replicationBlockingStub.getNodeIpsForReplication(NodeIpsRequest.newBuilder().
                setFilename(filename).build());
        System.out.println(response.getNodeipsList());
    }

    public void updateNodeReplicationStatus(String filename, List<String> nodeIps) {
        ReplicationDetailsResponse response = replicationBlockingStub.updateReplicationStatus(ReplicationDetailsRequest.newBuilder().
                setFilename(filename).addAllNodeips(nodeIps).build());
        System.out.println(response.getStatus());
    }

    public void getListOfFiles(String[] nodeIps) {
        GetListOfFilesResponse response = replicationBlockingStub.getListOfFiles(GetListOfFilesRequest.newBuilder()
                .addAllNodeips(Arrays.asList(nodeIps)).build());
        System.out.println(response.getFilenamesList());
    }

    public static void main(String[] args) {
        /*
        *   Testing
        * */
        ProxyNodeClient client = new ProxyNodeClient( "localhost", 6090);

        client.addNewNode("168.212.226.204");
        client.addNewNode("168.212.226.205");
        client.addNewNode("168.212.226.206");
        client.addNewNode("168.212.226.207");

        String nodeToUpload = client.getNodeForUpload("file1.txt", 1234);

        client.updateNodeReplicationStatus("file1.txt", Arrays.asList( "168.212. 226.204", "168.212. 226.205", "168.212. 226.206"));

        String nodeIpToDownload = client.getNodeForDownload("file1.txt");

        client.getNodeDownUpdate("168.212. 226.204");

        client.getNodeIpsForReplication("file1.txt");

        client.getListOfFiles(new String[]{"172.16.0.9", "192.0.0.7", "198.18.0.6"});
    }
}
