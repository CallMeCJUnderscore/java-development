package com.pluralsight.service;

import com.pluralsight.dao.impl.SimpleProductDAO;
import com.pluralsight.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductService {

    /*---------------VARIABLES---------------*/
    private final SimpleProductDAO simpleProductDAO;


    /*--------------CONSTRUCTORS-------------*/

    @Autowired
    public ProductService(SimpleProductDAO simpleProductDAO){
        this.simpleProductDAO = simpleProductDAO;
    }

    /*------------GETTERS/SETTERS------------*/



    /*---------------FUNCTIONS---------------*/

    public void addToInventory(Product product) throws ProductAlreadyExistsException{
        if(!this.simpleProductDAO.checkIfValid(product)){
            throw new ProductAlreadyExistsException();
        }
        else{
            this.simpleProductDAO.add(product);
        }
    }

    public void listProducts(){
        this.simpleProductDAO.getAll();
    }
}
