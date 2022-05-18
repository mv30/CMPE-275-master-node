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
        NewNodeUpdateResponse response = replicationBlockingStub.newNodeUpdate(NewNodeUpdateRequest.newBuilder().
                setNewnodeip(nodeIp).build());
        System.out.println(response.getStatus());
    }

    public void getNodeForUpload(String filename, long filesize) {
        GetNodeForUploadResponse response = replicationBlockingStub.getNodeForUpload(GetNodeForUploadRequest.newBuilder().
                setFilename(filename).setFilesize(filesize).build());
        System.out.println(response.getNodeip());
    }

    public void getNodeForDownload(String filename) {
        GetNodeForDownloadResponse response = replicationBlockingStub.getNodeForDownload(GetNodeForDownloadRequest.newBuilder().
                setFilename(filename).build());
        System.out.println(response.getNodeip());
    }

    public void getNodeDownUpdate(String nodeIp) {
        NodeDownUpdateResponse response = replicationBlockingStub.nodeDownUpdate(NodeDownUpdateRequest.newBuilder().
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

    public void getListOfNodes() {
        GetListOfNodesResponse response = replicationBlockingStub.getListOfNodes(GetListOfNodesRequest.newBuilder().build());
        System.out.println(response.getNodeipsList());
    }

    public static void main(String[] args) {
        /*
        *   Testing
        * */
        ProxyNodeClient client = new ProxyNodeClient( "ec2-18-189-2-173.us-east-2.compute.amazonaws.com", 6090);

        System.out.println("ADD NODE");
        client.addNewNode("168.212.226.204");
        client.addNewNode("168.212.226.205");
        client.addNewNode("168.212.226.206");
        client.addNewNode("168.212.226.207");

        System.out.println("NODE FOR FILE UPLOAD");
        client.getNodeForUpload("file1.txt", 1234);
        client.getNodeForUpload("file2.txt", 1234);
        client.getNodeForUpload("file3.txt", 1234);

        System.out.println("UPDATE REPLICATION STATUS");
        client.updateNodeReplicationStatus("file1.txt", Arrays.asList( "168.212.226.204", "168.212.226.205"));
        client.updateNodeReplicationStatus("file2.txt", Arrays.asList( "168.212.226.205", "168.212.226.206"));
        client.updateNodeReplicationStatus("file3.txt", Arrays.asList( "168.212.226.206", "168.212.226.207"));

        System.out.println("NODE FOR FILE DOWNLOAD");
        client.getNodeForDownload("file1.txt");
        client.getNodeForDownload("file2.txt");
        client.getNodeForDownload("file3.txt");

        System.out.println("NODE DOWN UPDATE");
        client.getNodeDownUpdate("168.212.226.204");

        System.out.println("LIST OF NODES");
        client.getListOfNodes();

        System.out.println("NODES FILE REPLICATED TO");
        client.getNodeIpsForReplication("file1.txt");
        client.getNodeIpsForReplication("file2.txt");
        client.getNodeIpsForReplication("file3.txt");

        System.out.println("LIST OF FILES");
        client.getListOfFiles(new String[]{"168.212.226.204", "168.212.226.205", "168.212.226.206", "168.212.226.207"});
    }
}
