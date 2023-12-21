package com.pluralsight.NorthwindTradersAPI.dao.interfaces;

import com.pluralsight.NorthwindTradersAPI.models.Category;

import java.util.List;

public interface ICategoryDAO {
    List<Category> getAll();
    Category getByID(int id);
}
