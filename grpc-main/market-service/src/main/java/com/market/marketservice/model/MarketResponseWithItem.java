package com.market.marketservice.model;

public class MarketResponseWithItem {

    private int id;

    private String category;

    private ItemResponse item;

    public MarketResponseWithItem(int id, String category, ItemResponse item) {
        this.id = id;
        this.category = category;
        this.item = item;
    }

    public MarketResponseWithItem() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public ItemResponse getItem() {
        return item;
    }

    public void setItem(ItemResponse item) {
        this.item = item;
    }
}
