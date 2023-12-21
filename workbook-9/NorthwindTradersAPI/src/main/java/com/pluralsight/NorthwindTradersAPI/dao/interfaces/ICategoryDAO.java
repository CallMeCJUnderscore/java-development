package com.pluralsight.NorthwindTradersAPI.dao.interfaces;

import com.pluralsight.NorthwindTradersAPI.models.Category;

import java.util.List;

public interface ICategoryDAO {
    List<Category> getAll();
    Category getByID(int id);
    Category insert(Category category);
    void update(int id, Category category);
    void delete(int id);
}
