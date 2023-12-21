package com.pluralsight.NorthwindTradersAPI.controllers;

import com.pluralsight.NorthwindTradersAPI.models.Category;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoryController {

    private List<Category> categories = new ArrayList<>();

    public CategoryController() {
        categories.add(new Category(1, "Meat"));
        categories.add(new Category(2, "Dairy"));
        categories.add(new Category(3, "Fruit"));
        categories.add(new Category(4, "Vegetables"));
        categories.add(new Category(5, "Beverages"));

    }

    @RequestMapping(path = "/categories", method = RequestMethod.GET)
    public List<Category> listCategories(@RequestParam(required = false) String name){
        if(name != null) {
            List<Category> found = new ArrayList<>();
            for (Category category : categories) {
                if (category.getCategoryName().equalsIgnoreCase(name)) {
                    found.add(category);
                }
            }
            return found;
        }
        return categories;
    }

    @RequestMapping(path = "/categories/{id}", method = RequestMethod.GET)
    public List<Category> getCategoryByID(@PathVariable int id){
            List<Category> found = new ArrayList<>();
            for(Category category : categories){
                if(category.getCategoryID() == id){
                    found.add(category);
                }
            }
        return found;
    }

/*    @RequestMapping(path = "/categories", method = RequestMethod.GET)
    public List<Category> getCategoryByName(@RequestParam(required = false) String name){
        List<Category> found = new ArrayList<>();
        if(name != null) {
            for (Category category : categories) {
                if (category.getCategoryName().toLowerCase().equals(name)) {
                    found.add(category);
                }
            }

        }
        return found;
    }*/

}
