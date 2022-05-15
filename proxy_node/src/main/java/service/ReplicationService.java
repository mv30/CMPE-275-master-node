package service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entry.IpDetailsEntry;
import io.grpc.replication.DataNode.DataPayload;
import io.grpc.stub.StreamObserver;
import org.master.protos.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class ReplicationService extends ReplicationGrpc.ReplicationImplBase {

    MonitorService monitorService = new MonitorService(-1);
    List<Integer> activeServerNodeIds = new ArrayList<>();

    private int countActiveNodes() {
        Set<Integer> inactivePeers = monitorService.getInactivePeers();
        System.out.println("Inactive Peers: " + inactivePeers);
        for(int inactivePeer : inactivePeers) {
            monitorService.removePeer(inactivePeer);
        }
        activeServerNodeIds.clear();
        activeServerNodeIds.addAll(monitorService.getAllServerIds());
        System.out.println("Active Peers: " + activeServerNodeIds);
        System.out.println("Active Peers Size: " + activeServerNodeIds.size());
        return activeServerNodeIds.size();
    }

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
        int node = decimal.mod(new BigInteger(String.valueOf(countActiveNodes()))).intValue();
        return activeServerNodeIds.get(node);
    }

    @Override
    public void newNodeUpdate(NewNodeUpdateRequest request, StreamObserver<StatusResponse> responseObserver) {
        String nodeIp = request.getNewnodeip();
        int node = 0;
        try {
            node = findMasterNode(nodeIp);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        System.out.println("Data Node: " + node);
        IpDetailsEntry ip_entry = monitorService.getPeerInfo(node);
        ip_entry.getDataNodeClient().set("key1", nodeIp);

        StatusResponse.Builder response = StatusResponse.newBuilder();
        responseObserver.onNext(response.setStatus(Status.SUCCESS).build());
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
        System.out.println("Data Node: " + node);
        IpDetailsEntry ip_entry = monitorService.getPeerInfo(node);
        DataPayload dataPayload = ip_entry.getDataNodeClient().get(filename);

        GetNodeForDownloadResponse.Builder response = GetNodeForDownloadResponse.newBuilder();
        responseObserver.onNext(response.setNodeip(dataPayload.getValue()).build());
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
        System.out.println("Data Node: " + node);
        IpDetailsEntry ip_entry = monitorService.getPeerInfo(node);
        DataPayload dataPayload = ip_entry.getDataNodeClient().get(filename);

        GetNodeForUploadResponse.Builder response = GetNodeForUploadResponse.newBuilder();
        responseObserver.onNext(response.setNodeip(dataPayload.getValue()).build());
        responseObserver.onCompleted();
    }

    @Override
    public void nodeDownUpdate(NodeDownUpdateRequest request, StreamObserver<StatusResponse> responseObserver) {
        String nodeIp = request.getNodeip();
        int node = 0;
        try {
            node = findMasterNode(nodeIp);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        System.out.println("Data Node: " + node);
        IpDetailsEntry ip_entry = monitorService.getPeerInfo(node);
        ip_entry.getDataNodeClient().get(nodeIp);

        StatusResponse.Builder response = StatusResponse.newBuilder();
        responseObserver.onNext(response.setStatus(Status.FAILURE).build());
        responseObserver.onCompleted();
    }

    @Override
    public void getNodeIpsForReplication(NodeIpsRequest request, StreamObserver<NodeIpsReply> responseObserver) {
        String filename = request.getFilename();
        int node = 0;
        String[] node_ips = {};
        try {
            node = findMasterNode(filename);
            System.out.println(node);
            IpDetailsEntry ip_entry = monitorService.getPeerInfo(node);
            DataPayload dataPayload = ip_entry.getDataNodeClient().get(filename);
            ObjectMapper objectMapper = new ObjectMapper();
            node_ips = objectMapper.readValue(dataPayload.getValue(), String[].class);
        } catch (NoSuchAlgorithmException | JsonProcessingException e) {
            e.printStackTrace();
        }
        NodeIpsReply.Builder response = NodeIpsReply.newBuilder();
        responseObserver.onNext(response.addAllNodeips(Arrays.asList(node_ips)).build());
        responseObserver.onCompleted();
    }

    @Override
    public void updateReplicationStatus(ReplicationDetailsRequest request, StreamObserver<ReplicationDetailsResponse> responseObserver) {
        String filename = request.getFilename();
        String[] node_ips = {};
        node_ips = request.getNodeipsList().toArray(node_ips);
        ObjectMapper objectMapper = new ObjectMapper();
        String nodeIpJson = "";
        int node = 0;
        boolean flag = true;
        try {
            node = findMasterNode(filename);
            System.out.println(node);
            nodeIpJson = objectMapper.writeValueAsString(node_ips);
            IpDetailsEntry ip_entry = monitorService.getPeerInfo(node);
            ip_entry.getDataNodeClient().set(filename, nodeIpJson);
        } catch(NoSuchAlgorithmException | JsonProcessingException e) {
            flag = false;
            e.printStackTrace();
        }
        ReplicationDetailsResponse.Builder response = ReplicationDetailsResponse.newBuilder();
        responseObserver.onNext(response.setStatus(flag == true ? Status.SUCCESS : Status.FAILURE).build());
        responseObserver.onCompleted();
    }

    @Override
    public void getListOfFiles(GetListOfFilesRequest request, StreamObserver<GetListOfFilesResponse> responseObserver) {
        String[] node_ips = {};
        node_ips = request.getNodeipsList().toArray(node_ips);
        int node = 0;
        ArrayList<String> filenames = new ArrayList<>();

        try {
            for(String node_ip: node_ips) {
                node = findMasterNode(node_ip);
                String file = "Get file from node after getting proto";
                filenames.add(file);
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        GetListOfFilesResponse.Builder response = GetListOfFilesResponse.newBuilder();
        responseObserver.onNext(response.addAllFilenames(filenames).build());
        responseObserver.onCompleted();
    }
}
