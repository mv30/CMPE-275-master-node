package service;

import io.grpc.replication.DataNode.DataNodeStreamerGrpc;
import io.grpc.replication.DataNode.DataPayload;
import io.grpc.stub.StreamObserver;

import java.util.ArrayList;

public class DataNodeDbService extends DataNodeStreamerGrpc.DataNodeStreamerImplBase {

    private final MonitorService monitorService;

    private final FileHandler fileHandler;

    public DataNodeDbService(String filePath, MonitorService monitorService) {
        this.fileHandler = new FileHandler(filePath);
        this.monitorService = monitorService;
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
            Integer masterNode = monitorService.findMasterNode(key);
            if(monitorService.getHostServerId().equals(masterNode)) {
                Integer replicationNode = monitorService.findReplicationNode(key);
                if(!replicationNode.equals(masterNode)) {
                    monitorService.getPeerInfo(replicationNode).getDataNodeClient().set(key, value);
                }
            }
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
