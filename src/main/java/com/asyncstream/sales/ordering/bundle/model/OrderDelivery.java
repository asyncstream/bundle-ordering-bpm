package com.asyncstream.sales.ordering.bundle.model;

public class OrderDelivery {
    private String deliveryNumber;
    private String batchNumber;
    private DeliveryItem deliveryItem;
    private Address shippingAddress;

    public OrderDelivery(String deliveryNumber, String batchNumber, DeliveryItem deliveryItem, Address shippingAddress) {
        this.deliveryNumber = deliveryNumber;
        this.batchNumber = batchNumber;
        this.deliveryItem = deliveryItem;
        this.shippingAddress = shippingAddress;
    }

    public String getDeliveryNumber() {
        return deliveryNumber;
    }

    public String getBatchNumber() {
        return batchNumber;
    }

    public DeliveryItem getDeliveryItem() {
        return deliveryItem;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }
}
