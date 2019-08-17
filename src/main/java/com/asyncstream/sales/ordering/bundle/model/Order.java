package com.asyncstream.sales.ordering.bundle.model;

import java.util.List;

public class Order {
    private String orderNumber;
    private List<OrderItem> orderItems;
    private Address shippingAddress;

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }
}
