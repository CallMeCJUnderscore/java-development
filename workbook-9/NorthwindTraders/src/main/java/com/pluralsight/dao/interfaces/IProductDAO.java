package com.pluralsight.dao.interfaces;


import com.pluralsight.model.Product;

import java.util.List;

public interface IProductDAO {
    /*---------------VARIABLES---------------*/



    /*--------------CONSTRUCTORS-------------*/



    /*------------GETTERS/SETTERS------------*/



    /*---------------FUNCTIONS---------------*/


    public void add(Product product);
    public List<Product> getAll();
}

