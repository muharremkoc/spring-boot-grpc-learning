package com.market.marketservice.model;

import lombok.Builder;

public class Market {

    private int id;

    private String category;

    private int itemId;

    public Market(int id, String category, int itemId) {
        this.id = id;
        this.category = category;
        this.itemId = itemId;
    }

    public Market() {
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

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }
}
