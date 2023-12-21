package com.pluralsight.NorthwindTradersAPI.dao.interfaces;

import com.pluralsight.NorthwindTradersAPI.models.Product;

import java.util.List;

public interface IProductDAO {
    List<Product> getAll();
    Product getByID(int id);
    Product insert(Product product);
    void update(int id, Product product);
}
