package service;

import io.grpc.stub.StreamObserver;
import org.master.protos.*;

public class ReplicationService extends ReplicationGrpc.ReplicationImplBase {
    @Override
    public void newNodeUpdate(NewNodeUpdateRequest request, StreamObserver<StatusResponse> responseObserver) {
        String node_ip = request.getNewnodeip();
        System.out.println("Hello " + node_ip);
        StatusResponse.Builder response = StatusResponse.newBuilder();
        response.getStatusValue();

        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    @Override
    public void getNodeForDownload(GetNodeForDownloadRequest request, StreamObserver<GetNodeForDownloadResponse> responseObserver) {
        super.getNodeForDownload(request, responseObserver);
    }

    @Override
    public void getNodeForUpload(GetNodeForUploadRequest request, StreamObserver<GetNodeForUploadResponse> responseObserver) {
        super.getNodeForUpload(request, responseObserver);
    }

    @Override
    public void nodeDownUpdate(NodeDownUpdateRequest request, StreamObserver<StatusResponse> responseObserver) {
        super.nodeDownUpdate(request, responseObserver);
    }

    @Override
    public void getNodeIpsForReplication(NodeIpsRequest request, StreamObserver<NodeIpsReply> responseObserver) {
        super.getNodeIpsForReplication(request, responseObserver);
    }

    @Override
    public void updateReplicationStatus(ReplicationDetailsRequest request, StreamObserver<ReplicationDetailsResponse> responseObserver) {
        super.updateReplicationStatus(request, responseObserver);
    }

    @Override
    public void getListOfFiles(GetListOfFilesRequest request, StreamObserver<GetListOfFilesResponse> responseObserver) {
        super.getListOfFiles(request, responseObserver);
    }
}
