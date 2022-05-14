package io.grpc.replication.DataNode;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.44.1)",
    comments = "Source: message.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class DataNodeStreamerGrpc {

  private DataNodeStreamerGrpc() {}

  public static final String SERVICE_NAME = "message.DataNodeStreamer";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<io.grpc.replication.DataNode.DataPayload,
      io.grpc.replication.DataNode.DataPayload> getHealthPollMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "healthPoll",
      requestType = io.grpc.replication.DataNode.DataPayload.class,
      responseType = io.grpc.replication.DataNode.DataPayload.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.grpc.replication.DataNode.DataPayload,
      io.grpc.replication.DataNode.DataPayload> getHealthPollMethod() {
    io.grpc.MethodDescriptor<io.grpc.replication.DataNode.DataPayload, io.grpc.replication.DataNode.DataPayload> getHealthPollMethod;
    if ((getHealthPollMethod = DataNodeStreamerGrpc.getHealthPollMethod) == null) {
      synchronized (DataNodeStreamerGrpc.class) {
        if ((getHealthPollMethod = DataNodeStreamerGrpc.getHealthPollMethod) == null) {
          DataNodeStreamerGrpc.getHealthPollMethod = getHealthPollMethod =
              io.grpc.MethodDescriptor.<io.grpc.replication.DataNode.DataPayload, io.grpc.replication.DataNode.DataPayload>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "healthPoll"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.replication.DataNode.DataPayload.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.replication.DataNode.DataPayload.getDefaultInstance()))
              .setSchemaDescriptor(new DataNodeStreamerMethodDescriptorSupplier("healthPoll"))
              .build();
        }
      }
    }
    return getHealthPollMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.grpc.replication.DataNode.DataPayload,
      io.grpc.replication.DataNode.DataPayload> getSetDataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "setData",
      requestType = io.grpc.replication.DataNode.DataPayload.class,
      responseType = io.grpc.replication.DataNode.DataPayload.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.grpc.replication.DataNode.DataPayload,
      io.grpc.replication.DataNode.DataPayload> getSetDataMethod() {
    io.grpc.MethodDescriptor<io.grpc.replication.DataNode.DataPayload, io.grpc.replication.DataNode.DataPayload> getSetDataMethod;
    if ((getSetDataMethod = DataNodeStreamerGrpc.getSetDataMethod) == null) {
      synchronized (DataNodeStreamerGrpc.class) {
        if ((getSetDataMethod = DataNodeStreamerGrpc.getSetDataMethod) == null) {
          DataNodeStreamerGrpc.getSetDataMethod = getSetDataMethod =
              io.grpc.MethodDescriptor.<io.grpc.replication.DataNode.DataPayload, io.grpc.replication.DataNode.DataPayload>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "setData"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.replication.DataNode.DataPayload.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.replication.DataNode.DataPayload.getDefaultInstance()))
              .setSchemaDescriptor(new DataNodeStreamerMethodDescriptorSupplier("setData"))
              .build();
        }
      }
    }
    return getSetDataMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.grpc.replication.DataNode.DataPayload,
      io.grpc.replication.DataNode.DataPayload> getGetDataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getData",
      requestType = io.grpc.replication.DataNode.DataPayload.class,
      responseType = io.grpc.replication.DataNode.DataPayload.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.grpc.replication.DataNode.DataPayload,
      io.grpc.replication.DataNode.DataPayload> getGetDataMethod() {
    io.grpc.MethodDescriptor<io.grpc.replication.DataNode.DataPayload, io.grpc.replication.DataNode.DataPayload> getGetDataMethod;
    if ((getGetDataMethod = DataNodeStreamerGrpc.getGetDataMethod) == null) {
      synchronized (DataNodeStreamerGrpc.class) {
        if ((getGetDataMethod = DataNodeStreamerGrpc.getGetDataMethod) == null) {
          DataNodeStreamerGrpc.getGetDataMethod = getGetDataMethod =
              io.grpc.MethodDescriptor.<io.grpc.replication.DataNode.DataPayload, io.grpc.replication.DataNode.DataPayload>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getData"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.replication.DataNode.DataPayload.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.replication.DataNode.DataPayload.getDefaultInstance()))
              .setSchemaDescriptor(new DataNodeStreamerMethodDescriptorSupplier("getData"))
              .build();
        }
      }
    }
    return getGetDataMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DataNodeStreamerStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataNodeStreamerStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DataNodeStreamerStub>() {
        @java.lang.Override
        public DataNodeStreamerStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DataNodeStreamerStub(channel, callOptions);
        }
      };
    return DataNodeStreamerStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DataNodeStreamerBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataNodeStreamerBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DataNodeStreamerBlockingStub>() {
        @java.lang.Override
        public DataNodeStreamerBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DataNodeStreamerBlockingStub(channel, callOptions);
        }
      };
    return DataNodeStreamerBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static DataNodeStreamerFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataNodeStreamerFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DataNodeStreamerFutureStub>() {
        @java.lang.Override
        public DataNodeStreamerFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DataNodeStreamerFutureStub(channel, callOptions);
        }
      };
    return DataNodeStreamerFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class DataNodeStreamerImplBase implements io.grpc.BindableService {

    /**
     */
    public void healthPoll(io.grpc.replication.DataNode.DataPayload request,
        io.grpc.stub.StreamObserver<io.grpc.replication.DataNode.DataPayload> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getHealthPollMethod(), responseObserver);
    }

    /**
     */
    public void setData(io.grpc.replication.DataNode.DataPayload request,
        io.grpc.stub.StreamObserver<io.grpc.replication.DataNode.DataPayload> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSetDataMethod(), responseObserver);
    }

    /**
     */
    public void getData(io.grpc.replication.DataNode.DataPayload request,
        io.grpc.stub.StreamObserver<io.grpc.replication.DataNode.DataPayload> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetDataMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getHealthPollMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                io.grpc.replication.DataNode.DataPayload,
                io.grpc.replication.DataNode.DataPayload>(
                  this, METHODID_HEALTH_POLL)))
          .addMethod(
            getSetDataMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                io.grpc.replication.DataNode.DataPayload,
                io.grpc.replication.DataNode.DataPayload>(
                  this, METHODID_SET_DATA)))
          .addMethod(
            getGetDataMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                io.grpc.replication.DataNode.DataPayload,
                io.grpc.replication.DataNode.DataPayload>(
                  this, METHODID_GET_DATA)))
          .build();
    }
  }

  /**
   */
  public static final class DataNodeStreamerStub extends io.grpc.stub.AbstractAsyncStub<DataNodeStreamerStub> {
    private DataNodeStreamerStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataNodeStreamerStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataNodeStreamerStub(channel, callOptions);
    }

    /**
     */
    public void healthPoll(io.grpc.replication.DataNode.DataPayload request,
        io.grpc.stub.StreamObserver<io.grpc.replication.DataNode.DataPayload> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getHealthPollMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void setData(io.grpc.replication.DataNode.DataPayload request,
        io.grpc.stub.StreamObserver<io.grpc.replication.DataNode.DataPayload> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSetDataMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getData(io.grpc.replication.DataNode.DataPayload request,
        io.grpc.stub.StreamObserver<io.grpc.replication.DataNode.DataPayload> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDataMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class DataNodeStreamerBlockingStub extends io.grpc.stub.AbstractBlockingStub<DataNodeStreamerBlockingStub> {
    private DataNodeStreamerBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataNodeStreamerBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataNodeStreamerBlockingStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.replication.DataNode.DataPayload healthPoll(io.grpc.replication.DataNode.DataPayload request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getHealthPollMethod(), getCallOptions(), request);
    }

    /**
     */
    public io.grpc.replication.DataNode.DataPayload setData(io.grpc.replication.DataNode.DataPayload request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetDataMethod(), getCallOptions(), request);
    }

    /**
     */
    public io.grpc.replication.DataNode.DataPayload getData(io.grpc.replication.DataNode.DataPayload request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDataMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class DataNodeStreamerFutureStub extends io.grpc.stub.AbstractFutureStub<DataNodeStreamerFutureStub> {
    private DataNodeStreamerFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataNodeStreamerFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataNodeStreamerFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grpc.replication.DataNode.DataPayload> healthPoll(
        io.grpc.replication.DataNode.DataPayload request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getHealthPollMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grpc.replication.DataNode.DataPayload> setData(
        io.grpc.replication.DataNode.DataPayload request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSetDataMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grpc.replication.DataNode.DataPayload> getData(
        io.grpc.replication.DataNode.DataPayload request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDataMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_HEALTH_POLL = 0;
  private static final int METHODID_SET_DATA = 1;
  private static final int METHODID_GET_DATA = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final DataNodeStreamerImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DataNodeStreamerImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_HEALTH_POLL:
          serviceImpl.healthPoll((io.grpc.replication.DataNode.DataPayload) request,
              (io.grpc.stub.StreamObserver<io.grpc.replication.DataNode.DataPayload>) responseObserver);
          break;
        case METHODID_SET_DATA:
          serviceImpl.setData((io.grpc.replication.DataNode.DataPayload) request,
              (io.grpc.stub.StreamObserver<io.grpc.replication.DataNode.DataPayload>) responseObserver);
          break;
        case METHODID_GET_DATA:
          serviceImpl.getData((io.grpc.replication.DataNode.DataPayload) request,
              (io.grpc.stub.StreamObserver<io.grpc.replication.DataNode.DataPayload>) responseObserver);
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

  private static abstract class DataNodeStreamerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DataNodeStreamerBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return io.grpc.replication.DataNode.DataNode.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DataNodeStreamer");
    }
  }

  private static final class DataNodeStreamerFileDescriptorSupplier
      extends DataNodeStreamerBaseDescriptorSupplier {
    DataNodeStreamerFileDescriptorSupplier() {}
  }

  private static final class DataNodeStreamerMethodDescriptorSupplier
      extends DataNodeStreamerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    DataNodeStreamerMethodDescriptorSupplier(String methodName) {
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
      synchronized (DataNodeStreamerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new DataNodeStreamerFileDescriptorSupplier())
              .addMethod(getHealthPollMethod())
              .addMethod(getSetDataMethod())
              .addMethod(getGetDataMethod())
              .build();
        }
      }
    }
    return result;
  }
}
