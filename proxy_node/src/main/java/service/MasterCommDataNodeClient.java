package service;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.master.protos.*;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Arrays;

public class MasterCommDataNodeClient {

    private String hostName;

    private Integer portNo;

    private ReplicationGrpc.ReplicationBlockingStub stub;

    public MasterCommDataNodeClient( String hostName, Integer portNo) {
        this.hostName = hostName;
        this.portNo = portNo;
        ManagedChannel managedChannel = ManagedChannelBuilder
                .forTarget(String.format("%s:%s", this.hostName, this.portNo))
                .usePlaintext()
                .build();
        stub = ReplicationGrpc.newBlockingStub(managedChannel);
    }

    public DataPayload healthPoll(DataPayload dataPayload) {
        return stub.healthPoll(dataPayload);
    }

    public DataPayload setData(DataPayload dataPayload) {
        return stub.setData(dataPayload);
    }

    public DataPayload getData(DataPayload dataPayload) {
        return stub.getData(dataPayload);
    }

    public DataPayload removeData(DataPayload dataPayload) {
        return stub.removeData(dataPayload);
    }

    public StatusResponse newNodeUpdate( NewNodeUpdateRequest newNodeUpdateRequest) {
        stub.newNodeUpdate(newNodeUpdateRequest);
        return StatusResponse.newBuilder().setStatus(Status.SUCCESS).build();
    }

    public GetNodeForDownloadResponse getNodeForDownload(GetNodeForDownloadRequest getNodeForDownloadRequest) {
        return stub.getNodeForDownload(getNodeForDownloadRequest);
    }

    public GetNodeForUploadResponse getNodeForUpload( GetNodeForUploadRequest getNodeForUploadRequest) {
        return stub.getNodeForUpload(getNodeForUploadRequest);
    }

    public StatusResponse nodeDownUpdate(NodeDownUpdateRequest nodeDownUpdateRequest) {
        stub.nodeDownUpdate(nodeDownUpdateRequest);
        return StatusResponse.newBuilder().setStatus(Status.SUCCESS).build();
    }

    public GetListOfNodesResponse getListOfNodes( GetListOfNodesRequest getListOfNodesRequest) {
        return stub.getListOfNodes(getListOfNodesRequest);
    }

    public NodeIpsReply getNodeIpsForReplication(NodeIpsRequest nodeIpsRequest) {
        return stub.getNodeIpsForReplication(nodeIpsRequest);
    }

    public ReplicationDetailsResponse updateReplicationStatus(ReplicationDetailsRequest replicationDetailsRequest) {
        return stub.updateReplicationStatus(replicationDetailsRequest);
    }

    public GetListOfFilesResponse getListOfFiles(GetListOfFilesRequest getListOfFilesRequest) {
        return stub.getListOfFiles(getListOfFilesRequest);
    }

    public static void main(String[] args) {
        MasterCommDataNodeClient masterCommDataNodeClient = new MasterCommDataNodeClient("localhost", 6091);
        System.out.println("Testing Health Poll");
        masterCommDataNodeClient.healthPoll(DataPayload.newBuilder().build());
        System.out.println("Testing Set Data");
        masterCommDataNodeClient.setData(
                DataPayload
                        .newBuilder()
                        .setKey("cars")
                        .addAllValues(Arrays.asList("BMW", "Lexus", "Tesla")).build());
        masterCommDataNodeClient.setData(
                DataPayload
                        .newBuilder()
                        .setKey("trucks")
                        .addAllValues(Arrays.asList("Tahoe", "GMD", "Mahindra")).build());
        masterCommDataNodeClient.setData(
                DataPayload
                        .newBuilder()
                        .setKey("bikes")
                        .addAllValues(Arrays.asList("Ninja", "Y2k", "Duke KTM")).build());
        System.out.println("Testing Get Data");
        System.out.println(masterCommDataNodeClient.getData(DataPayload.newBuilder().setKey("cars").build()).getValuesList());
        System.out.println(masterCommDataNodeClient.getData(DataPayload.newBuilder().setKey("trucks").build()).getValuesList());
        System.out.println(masterCommDataNodeClient.getData(DataPayload.newBuilder().setKey("bikes").build()).getValuesList());
        System.out.println("Testing remove Data");
        masterCommDataNodeClient.removeData(DataPayload.newBuilder().setKey("bikes").build());
        System.out.println(masterCommDataNodeClient.getData(DataPayload.newBuilder().setKey("bikes").build()).getValuesList());
        System.out.println("Testing new node update");
        masterCommDataNodeClient.newNodeUpdate(NewNodeUpdateRequest.newBuilder().setNewnodeip("amazon-cloud").build());
        masterCommDataNodeClient.newNodeUpdate(NewNodeUpdateRequest.newBuilder().setNewnodeip("gcp-cloud").build());
        masterCommDataNodeClient.newNodeUpdate(NewNodeUpdateRequest.newBuilder().setNewnodeip("azure-cloud").build());
        System.out.println(" Testing getNode of upload ");
        System.out.println(masterCommDataNodeClient.getNodeForUpload(GetNodeForUploadRequest.newBuilder().setFilename("Ok").build()));
        System.out.println(" Testing getNode of download ");
        System.out.println(masterCommDataNodeClient.getNodeForDownload(GetNodeForDownloadRequest.newBuilder().setFilename("cars").build()));
        System.out.println(masterCommDataNodeClient.getNodeForDownload(GetNodeForDownloadRequest.newBuilder().setFilename("trucks").build()));
        System.out.println(" Testing getNode for replication ");
        System.out.println(masterCommDataNodeClient.getNodeIpsForReplication(NodeIpsRequest.newBuilder().setFilename("cars").build()));
        System.out.println(" Testing updateNode for replication ");
        masterCommDataNodeClient.updateReplicationStatus(ReplicationDetailsRequest.newBuilder().setFilename("cars").addAllNodeips(Arrays.asList("Audi", "Polo")).build());
        System.out.println(masterCommDataNodeClient.getNodeIpsForReplication(NodeIpsRequest.newBuilder().setFilename("cars").build()));
        System.out.println(" Testing get list of files ");
        System.out.println(masterCommDataNodeClient.getListOfFiles(GetListOfFilesRequest.newBuilder().addAllNodeips(Arrays.asList("BMW")).build()));
    }
}
