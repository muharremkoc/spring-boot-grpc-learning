package com.market.marketservice.server;


import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@GrpcService
public class MarketServiceServer extends MarketServiceGrpc.MarketServiceImplBase {

    private final static Logger log = LoggerFactory.getLogger(MarketServiceServer.class);

    @Override
    public void findMarketsByItemId(MarketRequest request, StreamObserver<MarketResponse> responseObserver) {
        log.info(String.format("Request received: %s", request.toString()));

        var itemMarkets = filterMarket(request.getItemId());
        var itemMarketsResponse = MarketResponse.newBuilder().addAllMarket(itemMarkets).build();

        log.info(String.format("Response post: %s", itemMarketsResponse.toString()));
        responseObserver.onNext(itemMarketsResponse);
        responseObserver.onCompleted();
    }

    private List<Market> filterMarket(int itemId) {
        List<Market> markets = Arrays.asList(
                Market.newBuilder().setId(1).setCategory("TECHNOLOGY").setItemId(1).build(),
                Market.newBuilder().setId(1).setCategory("ELECTRONIC").setItemId(1).build()
        );
        var filteredPosts = markets.stream().filter(post -> post.getItemId() == itemId).collect(Collectors.toList());
        return filteredPosts;
    }
}
