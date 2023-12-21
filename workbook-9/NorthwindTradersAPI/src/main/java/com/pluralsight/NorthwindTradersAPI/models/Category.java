package com.pluralsight.NorthwindTradersAPI.models;

public class Category {
    /*---------------VARIABLES---------------*/

    private int categoryID;
    private String categoryName;

    /*--------------CONSTRUCTORS-------------*/

    public Category(int categoryID, String categoryName) {
        this.categoryID = categoryID;
        this.categoryName = categoryName;
    }

    public Category() {
    }

    /*------------GETTERS/SETTERS------------*/

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    /*---------------FUNCTIONS---------------*/


}
