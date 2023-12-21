package com.pluralsight.NorthwindTradersAPI.controllers;

import com.pluralsight.NorthwindTradersAPI.dao.interfaces.ICategoryDAO;
import com.pluralsight.NorthwindTradersAPI.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    private final ICategoryDAO categoryDAO;

    @Autowired
    public CategoryController(ICategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    @RequestMapping(path = "/categories", method = RequestMethod.GET)
    public List<Category> listCategories(@RequestParam(required = false) String name){
        return categoryDAO.getAll();
    }

    @RequestMapping(path = "/categories/{id}", method = RequestMethod.GET)
    public Category getCategoryByID(@PathVariable int id){
            return categoryDAO.getByID(id);
    }

}
