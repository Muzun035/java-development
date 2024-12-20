package com.pluralsight;

public class Home extends Asset{
    private String address;

    public Home(String description, String dateAcquired, double originalCost, String address) {
        super(description, dateAcquired, originalCost);
        this.address = address;
    }

    public String getAddress(){
        return address;
    }
}