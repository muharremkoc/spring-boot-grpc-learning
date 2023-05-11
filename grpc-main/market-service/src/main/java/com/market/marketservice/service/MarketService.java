package com.market.marketservice.service;

import com.market.marketservice.client.ItemGrpcService;
import com.market.marketservice.model.ItemResponse;
import com.market.marketservice.model.Market;
import com.market.marketservice.model.MarketResponseWithItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class MarketService {

    private final ItemGrpcService itemGrpcService;

    public MarketService(ItemGrpcService itemGrpcService) {
        this.itemGrpcService = itemGrpcService;
    }

    public MarketResponseWithItem findMarketByIdWithItem(int marketId) {
        var market = filterMarket(marketId);
        var itemResponse = itemGrpcService.findItemById(market.getItemId());

        ItemResponse item = new ItemResponse(itemResponse.getId(), itemResponse.getName());
        var marketResponseWithItem = new MarketResponseWithItem(market.getId(), market.getCategory(), item);
        return marketResponseWithItem;
    }

    private Market filterMarket(int marketId) {
        List<Market> markets = Arrays.asList(
                new Market(1, "TECHNOLOGY", 1),
                new Market(2, "ELECTRONIC", 1)

        );
        var filteredMarket = markets.stream().filter(market -> market.getId() == marketId).findFirst();
        return filteredMarket.get();
    }

}
