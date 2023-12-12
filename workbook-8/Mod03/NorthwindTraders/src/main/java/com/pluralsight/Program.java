package com.pluralsight;

import java.sql.*;


public class Program {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        if (args.length != 2) {
            System.out.println(
                    "Application needs two arguments to run: " +
                            "java com.pluralsight.UsingDriverManager <username> <password>");
            System.exit(1);
        }

        String username = args[0];
        String password = args[1];
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection;
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind", username, password);



        String query = "SELECT ProductID, ProductName, UnitPrice, UnitsInStock FROM products";

        PreparedStatement preparedStatement = connection.prepareStatement(query);

        ResultSet results = preparedStatement.executeQuery(query);

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

        results.close();
        preparedStatement.close();
        connection.close();
    }
}
