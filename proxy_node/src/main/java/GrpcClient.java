import com.google.protobuf.ByteString;
import io.grpc.Channel;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import org.master.protos.NewNodeUpdateRequest;
import org.master.protos.ReplicationGrpc;
import org.master.protos.StatusResponse;

import java.io.*;

public class GrpcClient {

    private final ReplicationGrpc.ReplicationBlockingStub stub;

    public GrpcClient(Channel channel) {
        stub = ReplicationGrpc.newBlockingStub(channel);
    }

    void sendIp(String node_ip) {
        NewNodeUpdateRequest request = NewNodeUpdateRequest.newBuilder().setNewnodeip(node_ip).build();
        StatusResponse response = stub.newNodeUpdate(request);
        System.out.println(response.getStatus());
    }

    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 6090).usePlaintext().build();
        GrpcClient client = new GrpcClient(channel);
        client.sendIp("127.0.0.1");
    }
}
