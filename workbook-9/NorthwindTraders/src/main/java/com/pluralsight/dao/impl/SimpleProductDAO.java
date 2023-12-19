package com.pluralsight.dao.impl;

import com.pluralsight.dao.interfaces.IProductDAO;
import com.pluralsight.model.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SimpleProductDAO implements IProductDAO {
    /*---------------VARIABLES---------------*/

    private List<Product> products;


    /*--------------CONSTRUCTORS-------------*/

    public SimpleProductDAO(List<Product> products) {
        this.products = new ArrayList<>();
        products.add(new Product(1, "Milk", "Dairy", 5.99));
        products.add(new Product(2, "Eggs", "Dairy", 7.00));
        products.add(new Product(3, "Steak", "Meat", 8.50));
        products.add(new Product(4, "Chicken", "Meat", 6.75));
        products.add(new Product(5, "Apple Juice", "Drinks", 3.25));
    }

    /*------------GETTERS/SETTERS------------*/



    /*---------------FUNCTIONS---------------*/

    @Override
    public void add(Product newProduct) {
            products.add(newProduct);
    }

    @Override
    public List<Product> getAll() {
        return products;
    }
    public boolean checkIfValid(Product newProduct){
        int idToCheck = newProduct.getProductID();
        for (Product product:products) {
            if(idToCheck == product.getProductID()){
                return false;
            }
        }
        return true;
    }
}
