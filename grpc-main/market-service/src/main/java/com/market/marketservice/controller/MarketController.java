package com.market.marketservice.controller;

import com.market.marketservice.model.MarketResponseWithItem;
import com.market.marketservice.service.MarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/markets")
public class MarketController {


    private final MarketService marketService;

    @Autowired
    public MarketController(MarketService marketService) {
        this.marketService = marketService;
    }

    @GetMapping(path = "/{marketId}/items")
    public MarketResponseWithItem findMarketByIdWithItem(@PathVariable int marketId) {
        return marketService.findMarketByIdWithItem(marketId);
    }
}
