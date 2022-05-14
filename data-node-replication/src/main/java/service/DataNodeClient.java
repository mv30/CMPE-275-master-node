package service;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.replication.DataNode.DataNodeStreamerGrpc;
import io.grpc.replication.DataNode.DataPayload;

public class DataNodeClient {

    private final String SERVER_IP;

    private final Integer SERVER_PORT_NO;

    private final DataNodeStreamerGrpc.DataNodeStreamerBlockingStub dataNodeStreamerBlockingStub;

    public String getServerIp() {
        return this.SERVER_IP;
    }

    public Integer getServerPortNo() {
        return this.SERVER_PORT_NO;
    }

    public DataNodeClient( String SERVER_IP, Integer SERVER_PORT_NO) {
        this.SERVER_IP = SERVER_IP;
        this.SERVER_PORT_NO = SERVER_PORT_NO;
        ManagedChannel managedChannel = ManagedChannelBuilder.forTarget(String.format("%s:%s", this.SERVER_IP, this.SERVER_PORT_NO)).usePlaintext().build();
        dataNodeStreamerBlockingStub = DataNodeStreamerGrpc.newBlockingStub(managedChannel);
    }

    public void healthPoll() {
        dataNodeStreamerBlockingStub.healthPoll(DataPayload.newBuilder().build());
    }

    public void set( String key, String value) {
        DataPayload dataPayload = dataNodeStreamerBlockingStub.setData(DataPayload.newBuilder().setKey(key).setValue(value).build());
        System.out.println(dataPayload.getKey());
        System.out.println(dataPayload.getValue());
    }

    public void get(String key) {
        DataPayload dataPayload = dataNodeStreamerBlockingStub.getData(DataPayload.newBuilder().setKey(key).build());
        System.out.println(dataPayload.getKey());
        System.out.println(dataPayload.getValue());
    }

    public static void main(String[] args) {
        /*
        *   Testing
        * */
        DataNodeClient client = new DataNodeClient( "localhost", 6091);
        client.set("key1","value1");
        client.set("key2","value2");
        client.set("key3","value3");
        client.set("key4","value4");
        client.get("key1");
        client.get("key2");
        client.get("key3");
        client.get("key4");
        client.get("key1");
    }
}
