package service;

import io.grpc.replication.DataNode.DataNodeStreamerGrpc;
import io.grpc.replication.DataNode.DataPayload;
import io.grpc.stub.StreamObserver;

public class DataNodeDbService extends DataNodeStreamerGrpc.DataNodeStreamerImplBase {

    private final FileHandler fileHandler;

    public DataNodeDbService(String filePath) {
        this.fileHandler = new FileHandler(filePath);
    }

    @Override
    public void healthPoll(DataPayload request, StreamObserver<DataPayload> responseObserver) {
        responseObserver.onNext(DataPayload.newBuilder().build());
        responseObserver.onCompleted();
    }

    @Override
    public void setData(DataPayload request, StreamObserver<DataPayload> responseObserver) {
        String key = request.getKey();
        String value = request.getValue();
        try {
            fileHandler.createOrUpdate(key, value);
        } catch ( Exception e) {
            e.printStackTrace();
        }
        responseObserver.onNext(DataPayload.newBuilder().setKey(key).setValue(value).build());
        responseObserver.onCompleted();
    }

    @Override
    public void getData(DataPayload request, StreamObserver<DataPayload> responseObserver) {
        String key = request.getKey();
        String value = null;
        try {
            value = fileHandler.get(key);
        }catch (Exception e) {
            e.printStackTrace();
        }
        responseObserver.onNext(DataPayload.newBuilder().setKey(key).setValue(value).build());
        responseObserver.onCompleted();
    }

    @Override
    public void removeData(DataPayload request, StreamObserver<DataPayload> responseObserver) {
        String key = request.getKey();
        String value = null;
        try {
            value = fileHandler.remove(key).getValue();
        }catch (Exception e) {
            e.printStackTrace();
        }
        responseObserver.onNext(DataPayload.newBuilder().setKey(key).setValue(value).build());
        responseObserver.onCompleted();
    }
}
