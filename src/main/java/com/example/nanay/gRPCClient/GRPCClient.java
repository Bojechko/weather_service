package com.example.nanay.gRPCClient;

import com.example.nanay.gRPCServer.IsAllowedDescriptor;
import com.example.nanay.gRPCServer.IsAllowedServiceGrpc;
import io.grpc.Channel;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.concurrent.TimeUnit;

public class GRPCClient  {
    private final IsAllowedServiceGrpc.IsAllowedServiceBlockingStub blockingStub;

    public GRPCClient(Channel channel) {
        blockingStub = IsAllowedServiceGrpc.newBlockingStub(channel);
    }
    public boolean checkName(String name){
        IsAllowedDescriptor.IsAllowedRequest request = IsAllowedDescriptor.IsAllowedRequest.newBuilder().setName(name).build();
        IsAllowedDescriptor.IsAllowedReply response;

        response = blockingStub.send(request);

        return response.getIsAllowed();
    }

    static public boolean makeRequest(String name) throws InterruptedException {
        String target = "localhost:50051";
       // ManagedChannel channel = Grpc.newChannelBuilder(target, InsecureChannelCredentials.create()).build();
        ManagedChannel channel = ManagedChannelBuilder.forTarget(target)
                .usePlaintext()
                .build();
        GRPCClient client = new GRPCClient(channel);
        boolean response =  client.checkName(name);
        channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
        return response;
    }

}
