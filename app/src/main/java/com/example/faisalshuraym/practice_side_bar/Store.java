package com.example.faisalshuraym.practice_side_bar;

public class Store {
    String storeId;
    String storeName;

    public Store(String storeId, String storeName) {
        this.storeId = storeId;
        this.storeName = storeName;
    }

    public Store() {
    }

    public String getStoreId() {
        return storeId;
    }

    public String getStoreName() {
        return storeName;
    }
}
