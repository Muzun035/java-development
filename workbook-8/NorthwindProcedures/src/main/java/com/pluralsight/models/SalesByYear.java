package com.pluralsight.models;

public class SalesByYear {
    private String productName;
    private double totalSales;

    public SalesByYear(String productName, double totalSales) {
        this.productName = productName;
        this.totalSales = totalSales;
    }

    public String getProductName() {
        return productName;
    }

    public double getTotalSales() {
        return totalSales;
    }
}
