package service;

import io.grpc.stub.StreamObserver;
import org.master.protos.*;

public class ReplicationService extends ReplicationGrpc.ReplicationImplBase {

    MasterCommMonitorService monitorService = null;
    public ReplicationService( MasterCommMonitorService masterCommMonitorService) {
        this.monitorService = masterCommMonitorService;
    }

    @Override
    public void newNodeUpdate(NewNodeUpdateRequest request, StreamObserver<NewNodeUpdateResponse> responseObserver) {
        NewNodeUpdateResponse statusResponse = monitorService.newNodeUpdate(request);
        responseObserver.onNext(statusResponse);
        responseObserver.onCompleted();
    }

    @Override
    public void getNodeForDownload(GetNodeForDownloadRequest request, StreamObserver<GetNodeForDownloadResponse> responseObserver) {
        GetNodeForDownloadResponse response = monitorService.getNodeForDownload(request);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getNodeForUpload(GetNodeForUploadRequest request, StreamObserver<GetNodeForUploadResponse> responseObserver) {
        GetNodeForUploadResponse response = monitorService.getNodeForUpload(request);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void nodeDownUpdate(NodeDownUpdateRequest request, StreamObserver<NodeDownUpdateResponse> responseObserver) {
        NodeDownUpdateResponse response = monitorService.nodeDownUpdate(request);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getListOfNodes(GetListOfNodesRequest request, StreamObserver<GetListOfNodesResponse> responseObserver) {
        GetListOfNodesResponse response = monitorService.getListOfNodes(request);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getNodeIpsForReplication(NodeIpsRequest request, StreamObserver<NodeIpsReply> responseObserver) {
        NodeIpsReply response = monitorService.getNodeIpsForReplication(request);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void updateReplicationStatus(ReplicationDetailsRequest request, StreamObserver<ReplicationDetailsResponse> responseObserver) {
        ReplicationDetailsResponse response = null;
        try {
            response = monitorService.updateReplicationStatus(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getListOfFiles(GetListOfFilesRequest request, StreamObserver<GetListOfFilesResponse> responseObserver) {
        GetListOfFilesResponse response = monitorService.getListOfFiles(request);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
