package com.example.nanay.gRPCServer;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.38.0)",
    comments = "Source: is_allowed_descriptor.proto")
public final class IsAllowedServiceGrpc {

  private IsAllowedServiceGrpc() {}

  public static final String SERVICE_NAME = "com.example.nanay.gRPCServer.IsAllowedService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.nanay.gRPCServer.IsAllowedDescriptor.IsAllowedRequest,
      com.example.nanay.gRPCServer.IsAllowedDescriptor.IsAllowedReply> getSendMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "send",
      requestType = com.example.nanay.gRPCServer.IsAllowedDescriptor.IsAllowedRequest.class,
      responseType = com.example.nanay.gRPCServer.IsAllowedDescriptor.IsAllowedReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.nanay.gRPCServer.IsAllowedDescriptor.IsAllowedRequest,
      com.example.nanay.gRPCServer.IsAllowedDescriptor.IsAllowedReply> getSendMethod() {
    io.grpc.MethodDescriptor<com.example.nanay.gRPCServer.IsAllowedDescriptor.IsAllowedRequest, com.example.nanay.gRPCServer.IsAllowedDescriptor.IsAllowedReply> getSendMethod;
    if ((getSendMethod = IsAllowedServiceGrpc.getSendMethod) == null) {
      synchronized (IsAllowedServiceGrpc.class) {
        if ((getSendMethod = IsAllowedServiceGrpc.getSendMethod) == null) {
          IsAllowedServiceGrpc.getSendMethod = getSendMethod =
              io.grpc.MethodDescriptor.<com.example.nanay.gRPCServer.IsAllowedDescriptor.IsAllowedRequest, com.example.nanay.gRPCServer.IsAllowedDescriptor.IsAllowedReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "send"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.nanay.gRPCServer.IsAllowedDescriptor.IsAllowedRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.nanay.gRPCServer.IsAllowedDescriptor.IsAllowedReply.getDefaultInstance()))
              .setSchemaDescriptor(new IsAllowedServiceMethodDescriptorSupplier("send"))
              .build();
        }
      }
    }
    return getSendMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static IsAllowedServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<IsAllowedServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<IsAllowedServiceStub>() {
        @java.lang.Override
        public IsAllowedServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new IsAllowedServiceStub(channel, callOptions);
        }
      };
    return IsAllowedServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static IsAllowedServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<IsAllowedServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<IsAllowedServiceBlockingStub>() {
        @java.lang.Override
        public IsAllowedServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new IsAllowedServiceBlockingStub(channel, callOptions);
        }
      };
    return IsAllowedServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static IsAllowedServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<IsAllowedServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<IsAllowedServiceFutureStub>() {
        @java.lang.Override
        public IsAllowedServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new IsAllowedServiceFutureStub(channel, callOptions);
        }
      };
    return IsAllowedServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class IsAllowedServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void send(com.example.nanay.gRPCServer.IsAllowedDescriptor.IsAllowedRequest request,
        io.grpc.stub.StreamObserver<com.example.nanay.gRPCServer.IsAllowedDescriptor.IsAllowedReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSendMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSendMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.example.nanay.gRPCServer.IsAllowedDescriptor.IsAllowedRequest,
                com.example.nanay.gRPCServer.IsAllowedDescriptor.IsAllowedReply>(
                  this, METHODID_SEND)))
          .build();
    }
  }

  /**
   */
  public static final class IsAllowedServiceStub extends io.grpc.stub.AbstractAsyncStub<IsAllowedServiceStub> {
    private IsAllowedServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IsAllowedServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new IsAllowedServiceStub(channel, callOptions);
    }

    /**
     */
    public void send(com.example.nanay.gRPCServer.IsAllowedDescriptor.IsAllowedRequest request,
        io.grpc.stub.StreamObserver<com.example.nanay.gRPCServer.IsAllowedDescriptor.IsAllowedReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSendMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class IsAllowedServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<IsAllowedServiceBlockingStub> {
    private IsAllowedServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IsAllowedServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new IsAllowedServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.example.nanay.gRPCServer.IsAllowedDescriptor.IsAllowedReply send(com.example.nanay.gRPCServer.IsAllowedDescriptor.IsAllowedRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSendMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class IsAllowedServiceFutureStub extends io.grpc.stub.AbstractFutureStub<IsAllowedServiceFutureStub> {
    private IsAllowedServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IsAllowedServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new IsAllowedServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.nanay.gRPCServer.IsAllowedDescriptor.IsAllowedReply> send(
        com.example.nanay.gRPCServer.IsAllowedDescriptor.IsAllowedRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSendMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SEND = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final IsAllowedServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(IsAllowedServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SEND:
          serviceImpl.send((com.example.nanay.gRPCServer.IsAllowedDescriptor.IsAllowedRequest) request,
              (io.grpc.stub.StreamObserver<com.example.nanay.gRPCServer.IsAllowedDescriptor.IsAllowedReply>) responseObserver);
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

  private static abstract class IsAllowedServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    IsAllowedServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.nanay.gRPCServer.IsAllowedDescriptor.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("IsAllowedService");
    }
  }

  private static final class IsAllowedServiceFileDescriptorSupplier
      extends IsAllowedServiceBaseDescriptorSupplier {
    IsAllowedServiceFileDescriptorSupplier() {}
  }

  private static final class IsAllowedServiceMethodDescriptorSupplier
      extends IsAllowedServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    IsAllowedServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (IsAllowedServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new IsAllowedServiceFileDescriptorSupplier())
              .addMethod(getSendMethod())
              .build();
        }
      }
    }
    return result;
  }
}
