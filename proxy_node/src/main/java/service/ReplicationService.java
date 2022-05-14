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

    public int findMasterNode(String str) throws NoSuchAlgorithmException {
        String hashString = createHash(str);
        BigInteger decimal = new BigInteger(hashString, 16);
        int node = decimal.mod(new BigInteger("3")).intValue(); // TODO: dynamic number of nodes to modulo
        return node;
    }

    @Override
    public void newNodeUpdate(NewNodeUpdateRequest request, StreamObserver<StatusResponse> responseObserver) {
        String node_ip = request.getNewnodeip();
        int node = 0;
        try {
            node = findMasterNode(node_ip);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        System.out.println(node);
        // TODO: connect with appropriate master node
        StatusResponse.Builder response = StatusResponse.newBuilder();

        responseObserver.onNext(response.setStatus(response.getStatus()).build());
        responseObserver.onCompleted();
    }

    @Override
    public void getNodeForDownload(GetNodeForDownloadRequest request, StreamObserver<GetNodeForDownloadResponse> responseObserver) {
        String filename = request.getFilename();
        int node = 0;
        try {
            node = findMasterNode(filename);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        System.out.println(node);
        // TODO: connect with appropriate master node
        GetNodeForDownloadResponse.Builder response = GetNodeForDownloadResponse.newBuilder();
        String node_ip = response.getNodeip();

        responseObserver.onNext(response.setNodeip(node_ip).build());
        responseObserver.onCompleted();
    }

    @Override
    public void getNodeForUpload(GetNodeForUploadRequest request, StreamObserver<GetNodeForUploadResponse> responseObserver) {
        String filename = request.getFilename();
        long filesize = request.getFilesize();
        int node = 0;
        try {
            node = findMasterNode(filename);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        System.out.println(node);
        // TODO: connect with appropriate master node
        GetNodeForUploadResponse.Builder response = GetNodeForUploadResponse.newBuilder();
        String node_ip = response.getNodeip();

        responseObserver.onNext(response.setNodeip(node_ip).build());
        responseObserver.onCompleted();
    }

    @Override
    public void nodeDownUpdate(NodeDownUpdateRequest request, StreamObserver<StatusResponse> responseObserver) {
        String node_ip  = request.getNodeip();
        System.out.println("Checking if node is down " + node_ip);
        int node = 0;
        try {
            node = findMasterNode(node_ip);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        System.out.println(node);
        StatusResponse.Builder response = StatusResponse.newBuilder();

        // Change status after receiving node info
        responseObserver.onNext(response.setStatus(response.getStatus()).build());
        responseObserver.onCompleted();
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
