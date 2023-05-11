package com.market.marketservice.client;

import com.item.itemservice.server.ItemRequest;
import com.item.itemservice.server.ItemResponse;
import com.item.itemservice.server.ItemServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ItemGrpcService {
    @Value("${item.grpc.service.host}")
    private String itemGrpcServiceHost;

    @Value("${item.grpc.service.port}")
    private int itemGrpcServicePort;

    private final static Logger log = LoggerFactory.getLogger(ItemGrpcService.class);

    public ItemResponse findItemById(int userId) {
        log.info(String.format("Request sending item id: %s", userId));

        ManagedChannel channel = ManagedChannelBuilder.forAddress(itemGrpcServiceHost, itemGrpcServicePort)
                .usePlaintext()
                .build();

        ItemServiceGrpc.ItemServiceBlockingStub stub = ItemServiceGrpc.newBlockingStub(channel);

        var itemRequest = ItemRequest.newBuilder().setItemId(userId).build();
        var itemResponse = stub.findItemById(itemRequest);
        log.info(String.format("Response from item grpc server %s", itemResponse.toString()));
        channel.shutdown();
        return itemResponse;
    }
}
