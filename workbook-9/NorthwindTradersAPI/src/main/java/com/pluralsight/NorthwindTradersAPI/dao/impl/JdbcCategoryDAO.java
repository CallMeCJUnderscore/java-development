package com.pluralsight.NorthwindTradersAPI.dao.impl;

import com.pluralsight.NorthwindTradersAPI.dao.interfaces.ICategoryDAO;
import com.pluralsight.NorthwindTradersAPI.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcCategoryDAO implements ICategoryDAO {
    /*---------------VARIABLES---------------*/

    private final DataSource dataSource;

    /*--------------CONSTRUCTORS-------------*/

    @Autowired
    public JdbcCategoryDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    /*------------GETTERS/SETTERS------------*/



    /*---------------FUNCTIONS---------------*/

    @Override
    public List<Category> getAll() {
        List<Category> categories = new ArrayList<>();

        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT CategoryID, CategoryName FROM categories;");
            ResultSet resultSet = preparedStatement.executeQuery()){
            while (resultSet.next()){
                Category category = new Category(resultSet.getInt(1), resultSet.getString(2));
                categories.add(category);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return categories;
    }

    @Override
    public Category getByID(int id) {
        Category category = new Category();

        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT CategoryID, CategoryName FROM categories WHERE CategoryID = ?;")){
            preparedStatement.setInt(1, id);
            try(ResultSet resultSet = preparedStatement.executeQuery()){
                while (resultSet.next()){
                    category.setCategoryID(resultSet.getInt(1));
                    category.setCategoryName(resultSet.getString(2));
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return category;
    }

    @Override
    public Category insert(Category category) {
        try (Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO categories (CategoryName) VALUES(?)", Statement.RETURN_GENERATED_KEYS)){
            preparedStatement.setString(1, category.getCategoryName());

            int rows = preparedStatement.executeUpdate();
            if (rows ==0){
                throw new SQLException("Creating category failed, no rows affected");
            }
            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int generatedId = generatedKeys.getInt(1);
                    category.setCategoryID(generatedId);
                } else {
                    throw new SQLException("Creating category failed, no ID obtained.");
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return category;
    }

    @Override
    public void update(int id, Category category) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE categories SET CategoryName=? WHERE CategoryID=?", Statement.RETURN_GENERATED_KEYS)){
            preparedStatement.setString(1, category.getCategoryName());
            preparedStatement.setInt(2, id);

            int rows = preparedStatement.executeUpdate();
            if (rows ==0){
                throw new SQLException("Updating category failed, no rows affected");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


    @Override
    public void delete(int id) {
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM categories WHERE CategoryID=?")){
            preparedStatement.setInt(1, id);

            int rows = preparedStatement.executeUpdate();
            if (rows == 0){
                throw new SQLException("Deleting category failed, no rows affected");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
