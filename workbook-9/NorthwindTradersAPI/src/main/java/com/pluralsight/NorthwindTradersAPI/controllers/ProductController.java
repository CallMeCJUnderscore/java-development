package com.pluralsight.NorthwindTradersAPI.controllers;

import com.pluralsight.NorthwindTradersAPI.models.Product;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {
    List<Product> products = new ArrayList<>();

    public ProductController() {
        products.add(new Product(1, "Steak", 1, 8.00));
        products.add(new Product(2,"Chicken",1, 6.75));
        products.add(new Product(3, "Milk", 2, 5.00));
        products.add(new Product(4,"Apples", 3, 3.99));
        products.add(new Product(5,"Bananas", 3, 4.25));
        products.add(new Product(6, "Oranges", 3, 4.50));
        products.add(new Product(7,"Water", 5, 2.25));
        products.add(new Product(8, "Cider", 5, 4.99));
    }

    @RequestMapping(path = "/products", method = RequestMethod.GET)
    public List<Product> listProducts(){
        return products;
    }

    @RequestMapping(path = "/products/{id}", method = RequestMethod.GET)
    public List<Product> getProductByID(@PathVariable int id){
        List<Product> found = new ArrayList<>();
        for(Product product : products){
            if(product.getProductID() == id){
                found.add(product);
            }
        }
        return found;
    }


}
