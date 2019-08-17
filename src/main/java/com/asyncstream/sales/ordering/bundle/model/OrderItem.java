package com.asyncstream.sales.ordering.bundle.model;

public class OrderItem {
    private String itemNumber;
    private String category;
    private String subCategory;
    private Integer quantity;

    public void setItemNumber(String itemNumber) {
        this.itemNumber = itemNumber;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getItemNumber() {
        return itemNumber;
    }

    public String getCategory() {
        return category;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
