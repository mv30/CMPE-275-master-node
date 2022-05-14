package service;

import io.grpc.replication.DataNode.DataNodeStreamerGrpc;
import io.grpc.replication.DataNode.DataPayload;
import io.grpc.stub.StreamObserver;

public class DataNodeService extends DataNodeStreamerGrpc.DataNodeStreamerImplBase {

    private final String filePath;

    public DataNodeService( String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void healthPoll(DataPayload request, StreamObserver<DataPayload> responseObserver) {
        responseObserver.onNext(DataPayload.newBuilder().build());
        responseObserver.onCompleted();
    }

    @Override
    public void setData(DataPayload request, StreamObserver<DataPayload> responseObserver) {
        responseObserver.onNext(DataPayload.newBuilder().setKey("key-1").setValue("value-1").build());
        responseObserver.onCompleted();
    }

    @Override
    public void getData(DataPayload request, StreamObserver<DataPayload> responseObserver) {
        responseObserver.onNext(DataPayload.newBuilder().setKey("key-2").setValue("value-2").build());
        responseObserver.onCompleted();
    }
}
