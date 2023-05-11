package com.item.itemservice.controller;

import com.item.itemservice.model.Item;
import com.item.itemservice.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/{itemId}/posts")
    public Item findItemByIdWithMarkets(@PathVariable int itemId) {
        return itemService.findItemByIdWithMarkets(itemId);
    }
}
