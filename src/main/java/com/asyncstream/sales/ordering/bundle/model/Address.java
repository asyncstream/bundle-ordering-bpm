package com.asyncstream.sales.ordering.bundle.model;

public class Address {
    private String addressLine;
    private String country;
    private String city;
    private String zipCode;

    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getAddressLine() {
        return addressLine;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getZipCode() {
        return zipCode;
    }
}
