package com.asyncstream.sales.ordering.bundle.model;

public class DeliveryItem {
    private String orderNumber;
    private String itemNumber;

    public DeliveryItem(String orderNumber, String itemNumber) {
        this.orderNumber = orderNumber;
        this.itemNumber = itemNumber;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public String getItemNumber() {
        return itemNumber;
    }
}
