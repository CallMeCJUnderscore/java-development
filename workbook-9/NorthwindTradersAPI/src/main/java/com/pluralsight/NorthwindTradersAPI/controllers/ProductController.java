package com.pluralsight.NorthwindTradersAPI.controllers;

import com.pluralsight.NorthwindTradersAPI.dao.interfaces.IProductDAO;
import com.pluralsight.NorthwindTradersAPI.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    private final IProductDAO productDAO;

    @Autowired
    public ProductController(IProductDAO productDAO) {
        this.productDAO = productDAO;
    }


    @RequestMapping(path = "/products", method = RequestMethod.GET)
    public List<Product> listProducts(){
        return productDAO.getAll();
    }

    @RequestMapping(path = "/products/{id}", method = RequestMethod.GET)
    public Product getProductByID(@PathVariable int id){
        return productDAO.getByID(id);
    }


}
