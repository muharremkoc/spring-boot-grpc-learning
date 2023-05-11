package com.market.marketservice.model;

public class ItemResponse {

    private int id;

    private String name;

    public ItemResponse(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public ItemResponse() {
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
}
