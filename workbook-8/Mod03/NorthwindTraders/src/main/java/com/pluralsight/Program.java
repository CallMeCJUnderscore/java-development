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

            System.out.print("""
                    What do you want to do?
                    1) Display all products
                    2) Display all customers
                    3) Display all categories
                    0) Exit
                    Select an option:\s""");
            String command = scanner.nextLine();
            if (!command.matches("[123]")) {
                System.out.println("Goodbye...");
            } else {
                try (Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/northwind",
                        username,
                        password
                )){

                    if (command.equals("2")) {
                        try(PreparedStatement preparedStatement = connection.prepareStatement("SELECT ContactName, CompanyName, City, Country, Phone FROM customers ORDER BY Country");
                            ResultSet resultSet = preparedStatement.executeQuery()){
                            while (resultSet.next()) {
                                System.out.println("Contact Name: " + resultSet.getString("ContactName"));
                                System.out.println("Company Name: " + resultSet.getString("CompanyName"));
                                System.out.println("City: " + resultSet.getString("City"));
                                System.out.println("Country: " + resultSet.getString("Country"));
                                System.out.println("Phone Number: " + resultSet.getString("Phone"));
                                System.out.println("===================================================");
                            }
                        }
                        catch (Exception e) {
                            e.printStackTrace();
                        }

                    } else if (command.equals("1")) {
                        try(PreparedStatement preparedStatement = connection.prepareStatement("SELECT ProductID, ProductName, UnitPrice, UnitsInStock FROM products ORDER BY ProductID;"); ResultSet resultSet = preparedStatement.executeQuery()){
                            while (resultSet.next()) {
                                System.out.println("Product ID: " + resultSet.getString("ProductID"));
                                System.out.println("Product Name: " + resultSet.getString("ProductName"));
                                System.out.println("Unit Price: $" + resultSet.getString("UnitPrice"));
                                System.out.println("Units In Stock: " + resultSet.getString("UnitsInStock"));
                                System.out.println("===================================================");
                            }
                        }
                        catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    else if (command.equals("3")){
                        try(PreparedStatement preparedStatement = connection.prepareStatement(" SELECT CategoryID, CategoryName FROM categories ORDER BY CategoryID");
                            ResultSet resultSet = preparedStatement.executeQuery()){
                            while (resultSet.next()) {
                                System.out.println(resultSet.getString(1) + ") "+ resultSet.getString(2));
                            }
                        }
                        catch (Exception e) {
                            e.printStackTrace();
                        }
                        System.out.println("===================================================");
                        System.out.print("Select a category to search: ");
                        int toSearch = scanner.nextInt();
                        try(PreparedStatement preparedStatement = connection.prepareStatement("SELECT ProductID, ProductName, UnitPrice, UnitsInStock FROM products WHERE CategoryID LIKE ? ORDER BY ProductID;")){
                            preparedStatement.setInt(1, toSearch);

                            try(ResultSet resultSet = preparedStatement.executeQuery()){
                                while (resultSet.next()) {
                                    System.out.println("Product ID: " + resultSet.getString("ProductID"));
                                    System.out.println("Product Name: " + resultSet.getString("ProductName"));
                                    System.out.println("Unit Price: $" + resultSet.getString("UnitPrice"));
                                    System.out.println("Units In Stock: " + resultSet.getString("UnitsInStock"));
                                    System.out.println("===================================================");
                                }
                            }
                            catch (Exception e) {
                                e.printStackTrace();
                            }

                        }
                    }


                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }