package com.pluralsight;

import java.sql.*;


public class Program {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection;
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind", "root", "PluralsightLTCA2023!");

        String query = "SELECT ProductID, ProductName, UnitPrice, UnitsInStock FROM products";

        Statement statement = connection.createStatement();

        ResultSet results = statement.executeQuery(query);

        System.out.println("""
                +---+------------------------------+-------+-----+
                |ID |         Product Name         | Price |Stock|
                +---+------------------------------+-------+-----+""");
        while (results.next()){
            String id = String.format("%-3d",results.getInt(1));
            String productName = String.format("%-30.30s",results.getString(2));
            String price = String.format("%6.2f", results.getDouble(3));
            price = String.format("$%6.6s",price);
            String stock = String.format("%-5d", results.getInt(4));
            String output = String.format("|%s|%s|%s|%s|", id, productName, price, stock);
            System.out.println(output);
            System.out.println("+---+------------------------------+-------+-----+");
        }

        connection.close();
    }
}
