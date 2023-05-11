package com.item.itemservice.client;

import com.market.marketservice.server.Market;
import com.market.marketservice.server.MarketRequest;
import com.market.marketservice.server.MarketServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarketGrpcService {

    @Value("${market.grpc.service.host}")
    private String marketGrpcServiceHost;

    @Value("${market.grpc.service.port}")
    private int marketGrpcServicePort;

    private final static Logger log = LoggerFactory.getLogger(MarketGrpcService.class);

    public List<Market> findMarketsByItemId(int itemId) {

        log.info(String.format("Request sending user id: %s", itemId));

        ManagedChannel channel = ManagedChannelBuilder.forAddress(marketGrpcServiceHost, marketGrpcServicePort)
                .usePlaintext()
                .build();

        MarketServiceGrpc.MarketServiceBlockingStub stub = MarketServiceGrpc.newBlockingStub(channel);

        var postRequest = MarketRequest.newBuilder().setItemId(itemId).build();
        var postResponse = stub.findMarketsByItemId(postRequest);
        log.info(String.format("Response from post grpc server %s", postResponse.toString()));
        channel.shutdown();
        var postList = postResponse.getMarketList();
        return postList;
    }
}
