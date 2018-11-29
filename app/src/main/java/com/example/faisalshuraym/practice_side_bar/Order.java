package com.example.faisalshuraym.practice_side_bar;

public class Order {
    String orderId;
    String orderName;

    //Order Initialize
    public Order(String orderId, String orderName) {
        this.orderId = orderId;
        this.orderName = orderName;
    }
//Order contractor
    public Order(){

    }

    //You can get OrderID from another classes.
    public String getOrderId() {
        return orderId;
    }

    public String getOrderName() {
        return orderName;
    }
}
