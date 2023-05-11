package com.item.itemservice.model;

import lombok.Builder;

import java.util.List;

@Builder
public class Item {

    private int id;
    private String name;
    private List<Market> markets;

    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Item(int id, String name, List<Market> markets) {
        this.id = id;
        this.name = name;
        this.markets = markets;
    }

    public Item() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Market> getMarkets() {
        return markets;
    }

    public void setMarkets(List<Market> markets) {
        this.markets = markets;
    }
}
