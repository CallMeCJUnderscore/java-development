package com.pluralsight;

import java.sql.*;
import java.util.Scanner;

public class Program {
    public static void main(String[] args){
        if (args.length != 2) {
            System.out.println("We need a username and password to run the app");
            System.exit(1);
        }


        String username = args[0];
        String password = args[1];
        Scanner scanner = new Scanner(System.in);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (Exception e){
            e.printStackTrace();
            return;
        }

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        boolean repeat = true;
        while (repeat) {
            System.out.print("""
                    What do you want to do?
                    1) Display all products
                    2) Display all customers
                    0) Exit
                    Select an option:\s""");
            String input = scanner.nextLine();
            if (!input.matches("[12]")) {
                repeat = false;
            } else {
                try {
                    connection = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/northwind",
                            username,
                            password
                    );

                    if (input.equals("2")) {
                        preparedStatement = connection.prepareStatement(
                                """
                                        SELECT ContactName, CompanyName, City, Country, Phone
                                        FROM customers
                                        ORDER BY Country;
                                        """
                        );

                        resultSet = preparedStatement.executeQuery();

                        while (resultSet.next()) {
                            System.out.println("Contact Name: " + resultSet.getString("ContactName"));
                            System.out.println("Company Name: " + resultSet.getString("CompanyName"));
                            System.out.println("City: " + resultSet.getString("City"));
                            System.out.println("Country: " + resultSet.getString("Country"));
                            System.out.println("Phone Number: " + resultSet.getString("Phone"));
                            System.out.println("===================================================");
                        }
                    } else if (input.equals("1")) {
                        preparedStatement = connection.prepareStatement(
                                """
                                        SELECT ProductID, ProductName, UnitPrice, UnitsInStock
                                        FROM products
                                        ORDER BY ProductID;
                                        """
                        );

                        resultSet = preparedStatement.executeQuery();

                        while (resultSet.next()) {
                            System.out.println("Product ID: " + resultSet.getString("ProductID"));
                            System.out.println("Product Name: " + resultSet.getString("ProductName"));
                            System.out.println("Unit Price: $" + resultSet.getString("UnitPrice"));
                            System.out.println("Units In Stock: " + resultSet.getString("UnitsInStock"));
                            System.out.println("===================================================");
                        }
                    }


                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}