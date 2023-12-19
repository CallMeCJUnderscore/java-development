package com.pluralsight.service;

import com.pluralsight.dao.impl.ISimpleProductDAO;
import com.pluralsight.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductService {

    /*---------------VARIABLES---------------*/
    private final ISimpleProductDAO ISimpleProductDAO;


    /*--------------CONSTRUCTORS-------------*/

    @Autowired
    public ProductService(ISimpleProductDAO ISimpleProductDAO){
        this.ISimpleProductDAO = ISimpleProductDAO;
    }

    /*------------GETTERS/SETTERS------------*/



    /*---------------FUNCTIONS---------------*/

    public void addToInventory(Product product) throws ProductAlreadyExistsException{
        if(!this.ISimpleProductDAO.checkIfValid(product)){
            throw new ProductAlreadyExistsException();
        }
        else{
            this.ISimpleProductDAO.add(product);
        }
    }

    public void listProducts(){
        this.ISimpleProductDAO.getAll();
    }
}
