package serviceV2;

import io.grpc.stub.StreamObserver;
import org.master.protos.*;
import serviceV2.FileHandler;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

public class MasterCommDataNodeServerImpl extends ReplicationGrpc.ReplicationImplBase {

    String keyValueFilePath;

    String activeNodeFilePath;

    FileHandler keyValueFileHandler;

    FileHandler activeNodesFileHandler;

    public MasterCommDataNodeServerImpl( String keyValueFilePath, String activeNodeFilePath) {
        this.keyValueFilePath = keyValueFilePath;
        this.activeNodeFilePath = activeNodeFilePath;
        keyValueFileHandler = new FileHandler(keyValueFilePath);
        activeNodesFileHandler = new FileHandler(activeNodeFilePath);
    }

    /*
    *   Methods specific to Data Node
    * */
    @Override
    public void healthPoll(DataPayload request, StreamObserver<DataPayload> responseObserver) {
        responseObserver.onNext(DataPayload.newBuilder().build());
        responseObserver.onCompleted();
    }

    @Override
    public void setData(DataPayload request, StreamObserver<DataPayload> responseObserver) {
        String key = request.getKey();
        List<String> values = request.getValuesList();
        try {
            keyValueFileHandler.createOrUpdate( key, values);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
        responseObserver.onNext(DataPayload.newBuilder().setKey(key).addAllValues(values).build());
        responseObserver.onCompleted();
    }

    @Override
    public void getData(DataPayload request, StreamObserver<DataPayload> responseObserver) {
        String key = request.getKey();
        List<String> values = new ArrayList<>();
        try {
            values = keyValueFileHandler.get(key);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
        responseObserver.onNext(DataPayload.newBuilder().setKey(key).addAllValues(values).build());
        responseObserver.onCompleted();
    }

    @Override
    public void removeData(DataPayload request, StreamObserver<DataPayload> responseObserver) {
        String key = request.getKey();
        List<String> values = new ArrayList<>();
        try {
            DataEntry dataEntry = keyValueFileHandler.remove( key);
            values = dataEntry.getValues();
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
        responseObserver.onNext(DataPayload.newBuilder().setKey(key).addAllValues(values).build());
        responseObserver.onCompleted();
    }

    /*
    *   Methods specific to Gateway
    * */
    @Override
    public void newNodeUpdate(NewNodeUpdateRequest request, StreamObserver<StatusResponse> responseObserver) {
        String key = request.getNewnodeip();
        try {
            activeNodesFileHandler.createOrUpdate( key, new ArrayList<>());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        responseObserver.onNext(StatusResponse.newBuilder().setStatus(Status.SUCCESS).build());
        responseObserver.onCompleted();
    }

    @Override
    public void getNodeForDownload(GetNodeForDownloadRequest request, StreamObserver<GetNodeForDownloadResponse> responseObserver) {
        String key = request.getFilename();
        List<String> values = new ArrayList<>();
        try {
            values = keyValueFileHandler.get(key);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Collections.shuffle(values);
        responseObserver.onNext(GetNodeForDownloadResponse.newBuilder().setNodeip(values.get(0)).build());
        responseObserver.onCompleted();
    }

    @Override
    public void getNodeForUpload(GetNodeForUploadRequest request, StreamObserver<GetNodeForUploadResponse> responseObserver) {
        List<String> nodeIps = new ArrayList<>();
        try {
            nodeIps = activeNodesFileHandler.getFileContent().stream().map(DataEntry::getKey).collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Collections.shuffle(nodeIps);
        responseObserver.onNext(GetNodeForUploadResponse.newBuilder().setNodeip(nodeIps.get(0)).build());
        responseObserver.onCompleted();
    }

    /*
    *       Methods for Sentinel
    * */
    @Override
    public void nodeDownUpdate(NodeDownUpdateRequest request, StreamObserver<StatusResponse> responseObserver) {
        List<DataEntry> dataEntryList = new ArrayList<>();
        String key = request.getNodeip();
        try {
            dataEntryList = activeNodesFileHandler.getFileContent().stream().filter( dataEntry -> !key.equals(dataEntry.getKey())).collect(Collectors.toList());
            activeNodesFileHandler.writeData(dataEntryList);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        responseObserver.onNext(StatusResponse.newBuilder().setStatus(Status.SUCCESS).build());
        responseObserver.onCompleted();
    }

    /**
     *  Methods for Nodes
     * */
    @Override
    public void updateReplicationStatus(ReplicationDetailsRequest request, StreamObserver<ReplicationDetailsResponse> responseObserver) {
        String key = request.getFilename();
        List<String> incomingValues = request.getNodeipsList();
        try {
            List<String> values = keyValueFileHandler.get(key);
            values.addAll(incomingValues);
            values = new ArrayList<>(new HashSet<>(values));
            keyValueFileHandler.createOrUpdate( key, values);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        responseObserver.onNext(ReplicationDetailsResponse.newBuilder().setStatus(Status.SUCCESS).build());
        responseObserver.onCompleted();
    }

    @Override
    public void getNodeIpsForReplication(NodeIpsRequest request, StreamObserver<NodeIpsReply> responseObserver) {
        String key = request.getFilename();
        List<String> values = new ArrayList<>();
        try {
            values = keyValueFileHandler.get(key);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        responseObserver.onNext(NodeIpsReply.newBuilder().addAllNodeips(values).build());
        responseObserver.onCompleted();
    }

    /*
    *   Methods for CLI
    * */

    @Override
    public void getListOfFiles(GetListOfFilesRequest request, StreamObserver<GetListOfFilesResponse> responseObserver) {
        Set<String> fileNames = new HashSet<>();
        Set<String> targetNodeIps = new HashSet<>(request.getNodeipsList());
        List<DataEntry> dataEntryList = new ArrayList<>();
        try {
            dataEntryList = keyValueFileHandler.getFileContent();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        for(DataEntry dataEntry: dataEntryList) {
            List<String> fileNodeIps = dataEntry.getValues();
            if(targetNodeIps.isEmpty()) {
                fileNames.add(dataEntry.getKey());
            } else {
                for(String fileNodeId: fileNodeIps) {
                    if(targetNodeIps.contains(fileNodeId)) {
                        fileNames.add(dataEntry.getKey());
                        break;
                    }
                }
            }
        }
        responseObserver.onNext(GetListOfFilesResponse.newBuilder().addAllFilenames(fileNames).build());
        responseObserver.onCompleted();
    }
}
