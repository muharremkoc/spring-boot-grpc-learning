package com.item.itemservice.service;

import com.item.itemservice.client.MarketGrpcService;
import com.item.itemservice.model.Item;
import com.item.itemservice.model.Market;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {

       private final MarketGrpcService marketGrpcService;

    public ItemService(MarketGrpcService marketGrpcService) {
        this.marketGrpcService = marketGrpcService;
    }


    public Item findItemByIdWithMarkets(int itemId) {
        var itemMarkets = marketGrpcService.findMarketsByItemId(itemId);

        List<Market> markets = new ArrayList<>();
        itemMarkets.forEach(market -> markets.add(new Market(market.getId(),market.getCategory(), market.getItemId())));
        var user = new Item(1, "Computer",markets);
        return user;
    }

}
