package com.pluralsight.NorthwindTradersSpringBoot.dao.interfaces;

import com.pluralsight.NorthwindTradersSpringBoot.models.Product;

import java.util.List;

public interface IProductDao {
    void add(Product product);

    List<Product> getAll();

    Product getProductById(int productId);

    void update(Product product);

    void delete(Product product);
}
