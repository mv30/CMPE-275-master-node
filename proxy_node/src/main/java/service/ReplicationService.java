package service;

import io.grpc.stub.StreamObserver;
import org.master.protos.*;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ReplicationService extends ReplicationGrpc.ReplicationImplBase {

    private String convertToHex(final byte[] messageDigest) {
        BigInteger bigint = new BigInteger(1, messageDigest);
        String hex = bigint.toString(16);
        while (hex.length() < 32) {
            hex = "0".concat(hex);
        }
        return hex;
    }

    public String createHash(String input) throws NoSuchAlgorithmException {
        String hashString = null;
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] messageDigest = md.digest(input.getBytes());
        hashString = convertToHex(messageDigest);
        return hashString;
    }

    public int findNode(String hashString) {
        BigInteger decimal = new BigInteger(hashString, 16);
        int node = decimal.mod(new BigInteger("3")).intValue(); // TODO: dynamic number of nodes to modulo
        return node;
    }

    @Override
    public void newNodeUpdate(NewNodeUpdateRequest request, StreamObserver<StatusResponse> responseObserver) {
        String node_ip = request.getNewnodeip();
        int node = 0;
        try {
            String hash_value = createHash(node_ip);
            node = findNode(hash_value);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        System.out.println(node);
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
