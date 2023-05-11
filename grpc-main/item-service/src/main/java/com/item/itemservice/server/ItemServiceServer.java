package com.item.itemservice.server;


import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@GrpcService
public class ItemServiceServer extends ItemServiceGrpc.ItemServiceImplBase{

    private final static Logger log = LoggerFactory.getLogger(ItemServiceServer.class);

    @Override
    public void findItemById(ItemRequest request, StreamObserver<ItemResponse> responseObserver) {
        log.info(String.format("Request received: %s", request.toString()));

        var itemId = request.getItemId();
        var userResponse = ItemResponse.newBuilder().setId(itemId).setName("COMPUTER").build();

        responseObserver.onNext(userResponse);
        responseObserver.onCompleted();
    }

}
