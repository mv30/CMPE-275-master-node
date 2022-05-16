package org.master.protos;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.44.1)",
    comments = "Source: master-comm.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ReplicationGrpc {

  private ReplicationGrpc() {}

  public static final String SERVICE_NAME = "stream.Replication";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<org.master.protos.DataPayload,
      org.master.protos.DataPayload> getHealthPollMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "healthPoll",
      requestType = org.master.protos.DataPayload.class,
      responseType = org.master.protos.DataPayload.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.master.protos.DataPayload,
      org.master.protos.DataPayload> getHealthPollMethod() {
    io.grpc.MethodDescriptor<org.master.protos.DataPayload, org.master.protos.DataPayload> getHealthPollMethod;
    if ((getHealthPollMethod = ReplicationGrpc.getHealthPollMethod) == null) {
      synchronized (ReplicationGrpc.class) {
        if ((getHealthPollMethod = ReplicationGrpc.getHealthPollMethod) == null) {
          ReplicationGrpc.getHealthPollMethod = getHealthPollMethod =
              io.grpc.MethodDescriptor.<org.master.protos.DataPayload, org.master.protos.DataPayload>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "healthPoll"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.master.protos.DataPayload.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.master.protos.DataPayload.getDefaultInstance()))
              .setSchemaDescriptor(new ReplicationMethodDescriptorSupplier("healthPoll"))
              .build();
        }
      }
    }
    return getHealthPollMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.master.protos.DataPayload,
      org.master.protos.DataPayload> getSetDataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "setData",
      requestType = org.master.protos.DataPayload.class,
      responseType = org.master.protos.DataPayload.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.master.protos.DataPayload,
      org.master.protos.DataPayload> getSetDataMethod() {
    io.grpc.MethodDescriptor<org.master.protos.DataPayload, org.master.protos.DataPayload> getSetDataMethod;
    if ((getSetDataMethod = ReplicationGrpc.getSetDataMethod) == null) {
      synchronized (ReplicationGrpc.class) {
        if ((getSetDataMethod = ReplicationGrpc.getSetDataMethod) == null) {
          ReplicationGrpc.getSetDataMethod = getSetDataMethod =
              io.grpc.MethodDescriptor.<org.master.protos.DataPayload, org.master.protos.DataPayload>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "setData"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.master.protos.DataPayload.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.master.protos.DataPayload.getDefaultInstance()))
              .setSchemaDescriptor(new ReplicationMethodDescriptorSupplier("setData"))
              .build();
        }
      }
    }
    return getSetDataMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.master.protos.DataPayload,
      org.master.protos.DataPayload> getGetDataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getData",
      requestType = org.master.protos.DataPayload.class,
      responseType = org.master.protos.DataPayload.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.master.protos.DataPayload,
      org.master.protos.DataPayload> getGetDataMethod() {
    io.grpc.MethodDescriptor<org.master.protos.DataPayload, org.master.protos.DataPayload> getGetDataMethod;
    if ((getGetDataMethod = ReplicationGrpc.getGetDataMethod) == null) {
      synchronized (ReplicationGrpc.class) {
        if ((getGetDataMethod = ReplicationGrpc.getGetDataMethod) == null) {
          ReplicationGrpc.getGetDataMethod = getGetDataMethod =
              io.grpc.MethodDescriptor.<org.master.protos.DataPayload, org.master.protos.DataPayload>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getData"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.master.protos.DataPayload.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.master.protos.DataPayload.getDefaultInstance()))
              .setSchemaDescriptor(new ReplicationMethodDescriptorSupplier("getData"))
              .build();
        }
      }
    }
    return getGetDataMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.master.protos.DataPayload,
      org.master.protos.DataPayload> getRemoveDataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "removeData",
      requestType = org.master.protos.DataPayload.class,
      responseType = org.master.protos.DataPayload.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.master.protos.DataPayload,
      org.master.protos.DataPayload> getRemoveDataMethod() {
    io.grpc.MethodDescriptor<org.master.protos.DataPayload, org.master.protos.DataPayload> getRemoveDataMethod;
    if ((getRemoveDataMethod = ReplicationGrpc.getRemoveDataMethod) == null) {
      synchronized (ReplicationGrpc.class) {
        if ((getRemoveDataMethod = ReplicationGrpc.getRemoveDataMethod) == null) {
          ReplicationGrpc.getRemoveDataMethod = getRemoveDataMethod =
              io.grpc.MethodDescriptor.<org.master.protos.DataPayload, org.master.protos.DataPayload>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "removeData"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.master.protos.DataPayload.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.master.protos.DataPayload.getDefaultInstance()))
              .setSchemaDescriptor(new ReplicationMethodDescriptorSupplier("removeData"))
              .build();
        }
      }
    }
    return getRemoveDataMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.master.protos.NewNodeUpdateRequest,
      org.master.protos.StatusResponse> getNewNodeUpdateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "NewNodeUpdate",
      requestType = org.master.protos.NewNodeUpdateRequest.class,
      responseType = org.master.protos.StatusResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.master.protos.NewNodeUpdateRequest,
      org.master.protos.StatusResponse> getNewNodeUpdateMethod() {
    io.grpc.MethodDescriptor<org.master.protos.NewNodeUpdateRequest, org.master.protos.StatusResponse> getNewNodeUpdateMethod;
    if ((getNewNodeUpdateMethod = ReplicationGrpc.getNewNodeUpdateMethod) == null) {
      synchronized (ReplicationGrpc.class) {
        if ((getNewNodeUpdateMethod = ReplicationGrpc.getNewNodeUpdateMethod) == null) {
          ReplicationGrpc.getNewNodeUpdateMethod = getNewNodeUpdateMethod =
              io.grpc.MethodDescriptor.<org.master.protos.NewNodeUpdateRequest, org.master.protos.StatusResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "NewNodeUpdate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.master.protos.NewNodeUpdateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.master.protos.StatusResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ReplicationMethodDescriptorSupplier("NewNodeUpdate"))
              .build();
        }
      }
    }
    return getNewNodeUpdateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.master.protos.GetNodeForDownloadRequest,
      org.master.protos.GetNodeForDownloadResponse> getGetNodeForDownloadMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetNodeForDownload",
      requestType = org.master.protos.GetNodeForDownloadRequest.class,
      responseType = org.master.protos.GetNodeForDownloadResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.master.protos.GetNodeForDownloadRequest,
      org.master.protos.GetNodeForDownloadResponse> getGetNodeForDownloadMethod() {
    io.grpc.MethodDescriptor<org.master.protos.GetNodeForDownloadRequest, org.master.protos.GetNodeForDownloadResponse> getGetNodeForDownloadMethod;
    if ((getGetNodeForDownloadMethod = ReplicationGrpc.getGetNodeForDownloadMethod) == null) {
      synchronized (ReplicationGrpc.class) {
        if ((getGetNodeForDownloadMethod = ReplicationGrpc.getGetNodeForDownloadMethod) == null) {
          ReplicationGrpc.getGetNodeForDownloadMethod = getGetNodeForDownloadMethod =
              io.grpc.MethodDescriptor.<org.master.protos.GetNodeForDownloadRequest, org.master.protos.GetNodeForDownloadResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetNodeForDownload"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.master.protos.GetNodeForDownloadRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.master.protos.GetNodeForDownloadResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ReplicationMethodDescriptorSupplier("GetNodeForDownload"))
              .build();
        }
      }
    }
    return getGetNodeForDownloadMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.master.protos.GetNodeForUploadRequest,
      org.master.protos.GetNodeForUploadResponse> getGetNodeForUploadMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetNodeForUpload",
      requestType = org.master.protos.GetNodeForUploadRequest.class,
      responseType = org.master.protos.GetNodeForUploadResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.master.protos.GetNodeForUploadRequest,
      org.master.protos.GetNodeForUploadResponse> getGetNodeForUploadMethod() {
    io.grpc.MethodDescriptor<org.master.protos.GetNodeForUploadRequest, org.master.protos.GetNodeForUploadResponse> getGetNodeForUploadMethod;
    if ((getGetNodeForUploadMethod = ReplicationGrpc.getGetNodeForUploadMethod) == null) {
      synchronized (ReplicationGrpc.class) {
        if ((getGetNodeForUploadMethod = ReplicationGrpc.getGetNodeForUploadMethod) == null) {
          ReplicationGrpc.getGetNodeForUploadMethod = getGetNodeForUploadMethod =
              io.grpc.MethodDescriptor.<org.master.protos.GetNodeForUploadRequest, org.master.protos.GetNodeForUploadResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetNodeForUpload"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.master.protos.GetNodeForUploadRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.master.protos.GetNodeForUploadResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ReplicationMethodDescriptorSupplier("GetNodeForUpload"))
              .build();
        }
      }
    }
    return getGetNodeForUploadMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.master.protos.NodeDownUpdateRequest,
      org.master.protos.StatusResponse> getNodeDownUpdateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "NodeDownUpdate",
      requestType = org.master.protos.NodeDownUpdateRequest.class,
      responseType = org.master.protos.StatusResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.master.protos.NodeDownUpdateRequest,
      org.master.protos.StatusResponse> getNodeDownUpdateMethod() {
    io.grpc.MethodDescriptor<org.master.protos.NodeDownUpdateRequest, org.master.protos.StatusResponse> getNodeDownUpdateMethod;
    if ((getNodeDownUpdateMethod = ReplicationGrpc.getNodeDownUpdateMethod) == null) {
      synchronized (ReplicationGrpc.class) {
        if ((getNodeDownUpdateMethod = ReplicationGrpc.getNodeDownUpdateMethod) == null) {
          ReplicationGrpc.getNodeDownUpdateMethod = getNodeDownUpdateMethod =
              io.grpc.MethodDescriptor.<org.master.protos.NodeDownUpdateRequest, org.master.protos.StatusResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "NodeDownUpdate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.master.protos.NodeDownUpdateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.master.protos.StatusResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ReplicationMethodDescriptorSupplier("NodeDownUpdate"))
              .build();
        }
      }
    }
    return getNodeDownUpdateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.master.protos.NodeIpsRequest,
      org.master.protos.NodeIpsReply> getGetNodeIpsForReplicationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetNodeIpsForReplication",
      requestType = org.master.protos.NodeIpsRequest.class,
      responseType = org.master.protos.NodeIpsReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.master.protos.NodeIpsRequest,
      org.master.protos.NodeIpsReply> getGetNodeIpsForReplicationMethod() {
    io.grpc.MethodDescriptor<org.master.protos.NodeIpsRequest, org.master.protos.NodeIpsReply> getGetNodeIpsForReplicationMethod;
    if ((getGetNodeIpsForReplicationMethod = ReplicationGrpc.getGetNodeIpsForReplicationMethod) == null) {
      synchronized (ReplicationGrpc.class) {
        if ((getGetNodeIpsForReplicationMethod = ReplicationGrpc.getGetNodeIpsForReplicationMethod) == null) {
          ReplicationGrpc.getGetNodeIpsForReplicationMethod = getGetNodeIpsForReplicationMethod =
              io.grpc.MethodDescriptor.<org.master.protos.NodeIpsRequest, org.master.protos.NodeIpsReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetNodeIpsForReplication"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.master.protos.NodeIpsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.master.protos.NodeIpsReply.getDefaultInstance()))
              .setSchemaDescriptor(new ReplicationMethodDescriptorSupplier("GetNodeIpsForReplication"))
              .build();
        }
      }
    }
    return getGetNodeIpsForReplicationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.master.protos.ReplicationDetailsRequest,
      org.master.protos.ReplicationDetailsResponse> getUpdateReplicationStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateReplicationStatus",
      requestType = org.master.protos.ReplicationDetailsRequest.class,
      responseType = org.master.protos.ReplicationDetailsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.master.protos.ReplicationDetailsRequest,
      org.master.protos.ReplicationDetailsResponse> getUpdateReplicationStatusMethod() {
    io.grpc.MethodDescriptor<org.master.protos.ReplicationDetailsRequest, org.master.protos.ReplicationDetailsResponse> getUpdateReplicationStatusMethod;
    if ((getUpdateReplicationStatusMethod = ReplicationGrpc.getUpdateReplicationStatusMethod) == null) {
      synchronized (ReplicationGrpc.class) {
        if ((getUpdateReplicationStatusMethod = ReplicationGrpc.getUpdateReplicationStatusMethod) == null) {
          ReplicationGrpc.getUpdateReplicationStatusMethod = getUpdateReplicationStatusMethod =
              io.grpc.MethodDescriptor.<org.master.protos.ReplicationDetailsRequest, org.master.protos.ReplicationDetailsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateReplicationStatus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.master.protos.ReplicationDetailsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.master.protos.ReplicationDetailsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ReplicationMethodDescriptorSupplier("UpdateReplicationStatus"))
              .build();
        }
      }
    }
    return getUpdateReplicationStatusMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.master.protos.GetListOfFilesRequest,
      org.master.protos.GetListOfFilesResponse> getGetListOfFilesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetListOfFiles",
      requestType = org.master.protos.GetListOfFilesRequest.class,
      responseType = org.master.protos.GetListOfFilesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.master.protos.GetListOfFilesRequest,
      org.master.protos.GetListOfFilesResponse> getGetListOfFilesMethod() {
    io.grpc.MethodDescriptor<org.master.protos.GetListOfFilesRequest, org.master.protos.GetListOfFilesResponse> getGetListOfFilesMethod;
    if ((getGetListOfFilesMethod = ReplicationGrpc.getGetListOfFilesMethod) == null) {
      synchronized (ReplicationGrpc.class) {
        if ((getGetListOfFilesMethod = ReplicationGrpc.getGetListOfFilesMethod) == null) {
          ReplicationGrpc.getGetListOfFilesMethod = getGetListOfFilesMethod =
              io.grpc.MethodDescriptor.<org.master.protos.GetListOfFilesRequest, org.master.protos.GetListOfFilesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetListOfFiles"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.master.protos.GetListOfFilesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.master.protos.GetListOfFilesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ReplicationMethodDescriptorSupplier("GetListOfFiles"))
              .build();
        }
      }
    }
    return getGetListOfFilesMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ReplicationStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ReplicationStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ReplicationStub>() {
        @java.lang.Override
        public ReplicationStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ReplicationStub(channel, callOptions);
        }
      };
    return ReplicationStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ReplicationBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ReplicationBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ReplicationBlockingStub>() {
        @java.lang.Override
        public ReplicationBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ReplicationBlockingStub(channel, callOptions);
        }
      };
    return ReplicationBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ReplicationFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ReplicationFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ReplicationFutureStub>() {
        @java.lang.Override
        public ReplicationFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ReplicationFutureStub(channel, callOptions);
        }
      };
    return ReplicationFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class ReplicationImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Methods internal to data node operation
     * </pre>
     */
    public void healthPoll(org.master.protos.DataPayload request,
        io.grpc.stub.StreamObserver<org.master.protos.DataPayload> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getHealthPollMethod(), responseObserver);
    }

    /**
     */
    public void setData(org.master.protos.DataPayload request,
        io.grpc.stub.StreamObserver<org.master.protos.DataPayload> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSetDataMethod(), responseObserver);
    }

    /**
     */
    public void getData(org.master.protos.DataPayload request,
        io.grpc.stub.StreamObserver<org.master.protos.DataPayload> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetDataMethod(), responseObserver);
    }

    /**
     */
    public void removeData(org.master.protos.DataPayload request,
        io.grpc.stub.StreamObserver<org.master.protos.DataPayload> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRemoveDataMethod(), responseObserver);
    }

    /**
     * <pre>
     * Methods required for Gateway
     * </pre>
     */
    public void newNodeUpdate(org.master.protos.NewNodeUpdateRequest request,
        io.grpc.stub.StreamObserver<org.master.protos.StatusResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getNewNodeUpdateMethod(), responseObserver);
    }

    /**
     */
    public void getNodeForDownload(org.master.protos.GetNodeForDownloadRequest request,
        io.grpc.stub.StreamObserver<org.master.protos.GetNodeForDownloadResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetNodeForDownloadMethod(), responseObserver);
    }

    /**
     */
    public void getNodeForUpload(org.master.protos.GetNodeForUploadRequest request,
        io.grpc.stub.StreamObserver<org.master.protos.GetNodeForUploadResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetNodeForUploadMethod(), responseObserver);
    }

    /**
     * <pre>
     * Methods required for Sentinel
     * </pre>
     */
    public void nodeDownUpdate(org.master.protos.NodeDownUpdateRequest request,
        io.grpc.stub.StreamObserver<org.master.protos.StatusResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getNodeDownUpdateMethod(), responseObserver);
    }

    /**
     * <pre>
     * Methods required for Node
     * </pre>
     */
    public void getNodeIpsForReplication(org.master.protos.NodeIpsRequest request,
        io.grpc.stub.StreamObserver<org.master.protos.NodeIpsReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetNodeIpsForReplicationMethod(), responseObserver);
    }

    /**
     */
    public void updateReplicationStatus(org.master.protos.ReplicationDetailsRequest request,
        io.grpc.stub.StreamObserver<org.master.protos.ReplicationDetailsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateReplicationStatusMethod(), responseObserver);
    }

    /**
     * <pre>
     * Methods required for CLI
     * </pre>
     */
    public void getListOfFiles(org.master.protos.GetListOfFilesRequest request,
        io.grpc.stub.StreamObserver<org.master.protos.GetListOfFilesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetListOfFilesMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getHealthPollMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                org.master.protos.DataPayload,
                org.master.protos.DataPayload>(
                  this, METHODID_HEALTH_POLL)))
          .addMethod(
            getSetDataMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                org.master.protos.DataPayload,
                org.master.protos.DataPayload>(
                  this, METHODID_SET_DATA)))
          .addMethod(
            getGetDataMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                org.master.protos.DataPayload,
                org.master.protos.DataPayload>(
                  this, METHODID_GET_DATA)))
          .addMethod(
            getRemoveDataMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                org.master.protos.DataPayload,
                org.master.protos.DataPayload>(
                  this, METHODID_REMOVE_DATA)))
          .addMethod(
            getNewNodeUpdateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                org.master.protos.NewNodeUpdateRequest,
                org.master.protos.StatusResponse>(
                  this, METHODID_NEW_NODE_UPDATE)))
          .addMethod(
            getGetNodeForDownloadMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                org.master.protos.GetNodeForDownloadRequest,
                org.master.protos.GetNodeForDownloadResponse>(
                  this, METHODID_GET_NODE_FOR_DOWNLOAD)))
          .addMethod(
            getGetNodeForUploadMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                org.master.protos.GetNodeForUploadRequest,
                org.master.protos.GetNodeForUploadResponse>(
                  this, METHODID_GET_NODE_FOR_UPLOAD)))
          .addMethod(
            getNodeDownUpdateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                org.master.protos.NodeDownUpdateRequest,
                org.master.protos.StatusResponse>(
                  this, METHODID_NODE_DOWN_UPDATE)))
          .addMethod(
            getGetNodeIpsForReplicationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                org.master.protos.NodeIpsRequest,
                org.master.protos.NodeIpsReply>(
                  this, METHODID_GET_NODE_IPS_FOR_REPLICATION)))
          .addMethod(
            getUpdateReplicationStatusMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                org.master.protos.ReplicationDetailsRequest,
                org.master.protos.ReplicationDetailsResponse>(
                  this, METHODID_UPDATE_REPLICATION_STATUS)))
          .addMethod(
            getGetListOfFilesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                org.master.protos.GetListOfFilesRequest,
                org.master.protos.GetListOfFilesResponse>(
                  this, METHODID_GET_LIST_OF_FILES)))
          .build();
    }
  }

  /**
   */
  public static final class ReplicationStub extends io.grpc.stub.AbstractAsyncStub<ReplicationStub> {
    private ReplicationStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReplicationStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ReplicationStub(channel, callOptions);
    }

    /**
     * <pre>
     * Methods internal to data node operation
     * </pre>
     */
    public void healthPoll(org.master.protos.DataPayload request,
        io.grpc.stub.StreamObserver<org.master.protos.DataPayload> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getHealthPollMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void setData(org.master.protos.DataPayload request,
        io.grpc.stub.StreamObserver<org.master.protos.DataPayload> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSetDataMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getData(org.master.protos.DataPayload request,
        io.grpc.stub.StreamObserver<org.master.protos.DataPayload> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDataMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void removeData(org.master.protos.DataPayload request,
        io.grpc.stub.StreamObserver<org.master.protos.DataPayload> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRemoveDataMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Methods required for Gateway
     * </pre>
     */
    public void newNodeUpdate(org.master.protos.NewNodeUpdateRequest request,
        io.grpc.stub.StreamObserver<org.master.protos.StatusResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getNewNodeUpdateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getNodeForDownload(org.master.protos.GetNodeForDownloadRequest request,
        io.grpc.stub.StreamObserver<org.master.protos.GetNodeForDownloadResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetNodeForDownloadMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getNodeForUpload(org.master.protos.GetNodeForUploadRequest request,
        io.grpc.stub.StreamObserver<org.master.protos.GetNodeForUploadResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetNodeForUploadMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Methods required for Sentinel
     * </pre>
     */
    public void nodeDownUpdate(org.master.protos.NodeDownUpdateRequest request,
        io.grpc.stub.StreamObserver<org.master.protos.StatusResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getNodeDownUpdateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Methods required for Node
     * </pre>
     */
    public void getNodeIpsForReplication(org.master.protos.NodeIpsRequest request,
        io.grpc.stub.StreamObserver<org.master.protos.NodeIpsReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetNodeIpsForReplicationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateReplicationStatus(org.master.protos.ReplicationDetailsRequest request,
        io.grpc.stub.StreamObserver<org.master.protos.ReplicationDetailsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateReplicationStatusMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Methods required for CLI
     * </pre>
     */
    public void getListOfFiles(org.master.protos.GetListOfFilesRequest request,
        io.grpc.stub.StreamObserver<org.master.protos.GetListOfFilesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetListOfFilesMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ReplicationBlockingStub extends io.grpc.stub.AbstractBlockingStub<ReplicationBlockingStub> {
    private ReplicationBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReplicationBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ReplicationBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Methods internal to data node operation
     * </pre>
     */
    public org.master.protos.DataPayload healthPoll(org.master.protos.DataPayload request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getHealthPollMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.master.protos.DataPayload setData(org.master.protos.DataPayload request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetDataMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.master.protos.DataPayload getData(org.master.protos.DataPayload request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDataMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.master.protos.DataPayload removeData(org.master.protos.DataPayload request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRemoveDataMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Methods required for Gateway
     * </pre>
     */
    public org.master.protos.StatusResponse newNodeUpdate(org.master.protos.NewNodeUpdateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getNewNodeUpdateMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.master.protos.GetNodeForDownloadResponse getNodeForDownload(org.master.protos.GetNodeForDownloadRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetNodeForDownloadMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.master.protos.GetNodeForUploadResponse getNodeForUpload(org.master.protos.GetNodeForUploadRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetNodeForUploadMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Methods required for Sentinel
     * </pre>
     */
    public org.master.protos.StatusResponse nodeDownUpdate(org.master.protos.NodeDownUpdateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getNodeDownUpdateMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Methods required for Node
     * </pre>
     */
    public org.master.protos.NodeIpsReply getNodeIpsForReplication(org.master.protos.NodeIpsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetNodeIpsForReplicationMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.master.protos.ReplicationDetailsResponse updateReplicationStatus(org.master.protos.ReplicationDetailsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateReplicationStatusMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Methods required for CLI
     * </pre>
     */
    public org.master.protos.GetListOfFilesResponse getListOfFiles(org.master.protos.GetListOfFilesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetListOfFilesMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ReplicationFutureStub extends io.grpc.stub.AbstractFutureStub<ReplicationFutureStub> {
    private ReplicationFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReplicationFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ReplicationFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Methods internal to data node operation
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<org.master.protos.DataPayload> healthPoll(
        org.master.protos.DataPayload request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getHealthPollMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.master.protos.DataPayload> setData(
        org.master.protos.DataPayload request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSetDataMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.master.protos.DataPayload> getData(
        org.master.protos.DataPayload request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDataMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.master.protos.DataPayload> removeData(
        org.master.protos.DataPayload request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRemoveDataMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Methods required for Gateway
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<org.master.protos.StatusResponse> newNodeUpdate(
        org.master.protos.NewNodeUpdateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getNewNodeUpdateMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.master.protos.GetNodeForDownloadResponse> getNodeForDownload(
        org.master.protos.GetNodeForDownloadRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetNodeForDownloadMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.master.protos.GetNodeForUploadResponse> getNodeForUpload(
        org.master.protos.GetNodeForUploadRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetNodeForUploadMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Methods required for Sentinel
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<org.master.protos.StatusResponse> nodeDownUpdate(
        org.master.protos.NodeDownUpdateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getNodeDownUpdateMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Methods required for Node
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<org.master.protos.NodeIpsReply> getNodeIpsForReplication(
        org.master.protos.NodeIpsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetNodeIpsForReplicationMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.master.protos.ReplicationDetailsResponse> updateReplicationStatus(
        org.master.protos.ReplicationDetailsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateReplicationStatusMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Methods required for CLI
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<org.master.protos.GetListOfFilesResponse> getListOfFiles(
        org.master.protos.GetListOfFilesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetListOfFilesMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_HEALTH_POLL = 0;
  private static final int METHODID_SET_DATA = 1;
  private static final int METHODID_GET_DATA = 2;
  private static final int METHODID_REMOVE_DATA = 3;
  private static final int METHODID_NEW_NODE_UPDATE = 4;
  private static final int METHODID_GET_NODE_FOR_DOWNLOAD = 5;
  private static final int METHODID_GET_NODE_FOR_UPLOAD = 6;
  private static final int METHODID_NODE_DOWN_UPDATE = 7;
  private static final int METHODID_GET_NODE_IPS_FOR_REPLICATION = 8;
  private static final int METHODID_UPDATE_REPLICATION_STATUS = 9;
  private static final int METHODID_GET_LIST_OF_FILES = 10;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ReplicationImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ReplicationImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_HEALTH_POLL:
          serviceImpl.healthPoll((org.master.protos.DataPayload) request,
              (io.grpc.stub.StreamObserver<org.master.protos.DataPayload>) responseObserver);
          break;
        case METHODID_SET_DATA:
          serviceImpl.setData((org.master.protos.DataPayload) request,
              (io.grpc.stub.StreamObserver<org.master.protos.DataPayload>) responseObserver);
          break;
        case METHODID_GET_DATA:
          serviceImpl.getData((org.master.protos.DataPayload) request,
              (io.grpc.stub.StreamObserver<org.master.protos.DataPayload>) responseObserver);
          break;
        case METHODID_REMOVE_DATA:
          serviceImpl.removeData((org.master.protos.DataPayload) request,
              (io.grpc.stub.StreamObserver<org.master.protos.DataPayload>) responseObserver);
          break;
        case METHODID_NEW_NODE_UPDATE:
          serviceImpl.newNodeUpdate((org.master.protos.NewNodeUpdateRequest) request,
              (io.grpc.stub.StreamObserver<org.master.protos.StatusResponse>) responseObserver);
          break;
        case METHODID_GET_NODE_FOR_DOWNLOAD:
          serviceImpl.getNodeForDownload((org.master.protos.GetNodeForDownloadRequest) request,
              (io.grpc.stub.StreamObserver<org.master.protos.GetNodeForDownloadResponse>) responseObserver);
          break;
        case METHODID_GET_NODE_FOR_UPLOAD:
          serviceImpl.getNodeForUpload((org.master.protos.GetNodeForUploadRequest) request,
              (io.grpc.stub.StreamObserver<org.master.protos.GetNodeForUploadResponse>) responseObserver);
          break;
        case METHODID_NODE_DOWN_UPDATE:
          serviceImpl.nodeDownUpdate((org.master.protos.NodeDownUpdateRequest) request,
              (io.grpc.stub.StreamObserver<org.master.protos.StatusResponse>) responseObserver);
          break;
        case METHODID_GET_NODE_IPS_FOR_REPLICATION:
          serviceImpl.getNodeIpsForReplication((org.master.protos.NodeIpsRequest) request,
              (io.grpc.stub.StreamObserver<org.master.protos.NodeIpsReply>) responseObserver);
          break;
        case METHODID_UPDATE_REPLICATION_STATUS:
          serviceImpl.updateReplicationStatus((org.master.protos.ReplicationDetailsRequest) request,
              (io.grpc.stub.StreamObserver<org.master.protos.ReplicationDetailsResponse>) responseObserver);
          break;
        case METHODID_GET_LIST_OF_FILES:
          serviceImpl.getListOfFiles((org.master.protos.GetListOfFilesRequest) request,
              (io.grpc.stub.StreamObserver<org.master.protos.GetListOfFilesResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ReplicationBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ReplicationBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return org.master.protos.MasterComm.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Replication");
    }
  }

  private static final class ReplicationFileDescriptorSupplier
      extends ReplicationBaseDescriptorSupplier {
    ReplicationFileDescriptorSupplier() {}
  }

  private static final class ReplicationMethodDescriptorSupplier
      extends ReplicationBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ReplicationMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ReplicationGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ReplicationFileDescriptorSupplier())
              .addMethod(getHealthPollMethod())
              .addMethod(getSetDataMethod())
              .addMethod(getGetDataMethod())
              .addMethod(getRemoveDataMethod())
              .addMethod(getNewNodeUpdateMethod())
              .addMethod(getGetNodeForDownloadMethod())
              .addMethod(getGetNodeForUploadMethod())
              .addMethod(getNodeDownUpdateMethod())
              .addMethod(getGetNodeIpsForReplicationMethod())
              .addMethod(getUpdateReplicationStatusMethod())
              .addMethod(getGetListOfFilesMethod())
              .build();
        }
      }
    }
    return result;
  }
}
