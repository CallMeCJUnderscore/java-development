package com.pluralsight.NorthwindTradersAPI.dao.impl;

import com.pluralsight.NorthwindTradersAPI.dao.interfaces.IProductDAO;
import com.pluralsight.NorthwindTradersAPI.models.Category;
import com.pluralsight.NorthwindTradersAPI.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcProductDAO implements IProductDAO {
    /*---------------VARIABLES---------------*/

    private final DataSource dataSource;

    /*--------------CONSTRUCTORS-------------*/

    @Autowired
    public JdbcProductDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    /*------------GETTERS/SETTERS------------*/



    /*---------------FUNCTIONS---------------*/

    @Override
    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();

        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT ProductID, ProductName, CategoryID, UnitPrice FROM products;");
            ResultSet resultSet = preparedStatement.executeQuery();){
            while (resultSet.next()){
                int productID = resultSet.getInt(1);
                String name = resultSet.getString(2);
                int categoryID = resultSet.getInt(3);
                double unitPrice = resultSet.getDouble(4);
                Product product = new Product(productID, name, categoryID, unitPrice);
                products.add(product);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public Product getByID(int id) {
        Product product = new Product();

        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT ProductID, ProductName, CategoryID, UnitPrice FROM products WHERE ProductID = ?;")){
            preparedStatement.setInt(1, id);
            try(ResultSet resultSet = preparedStatement.executeQuery()){
                while (resultSet.next()){
                    product.setProductID(resultSet.getInt(1));
                    product.setProductName(resultSet.getString(2));
                    product.setCategoryID(resultSet.getInt(3));
                    product.setUnitPrice(resultSet.getDouble(4));
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public Product insert(Product product) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO products (ProductName, CategoryID, UnitPrice) VALUES(?,?,?)", Statement.RETURN_GENERATED_KEYS)){
            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setInt(2, product.getCategoryID());
            preparedStatement.setDouble(3, product.getUnitPrice());

            int rows = preparedStatement.executeUpdate();
            if (rows == 0){
                throw new SQLException("Creating category failed, no rows affected");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return product;
    }
}
