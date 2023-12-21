package com.pluralsight.NorthwindTradersAPI.models;

public class Product {
    /*---------------VARIABLES---------------*/

    private int productID;
    private String productName;
    private int categoryID;
    private double unitPrice;

    /*--------------CONSTRUCTORS-------------*/

    public Product(int productID, String productName, int categoryID, double unitPrice) {
        this.productID = productID;
        this.productName = productName;
        this.categoryID = categoryID;
        this.unitPrice = unitPrice;
    }

    public Product() {
    }

    /*------------GETTERS/SETTERS------------*/

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    /*---------------FUNCTIONS---------------*/


}
