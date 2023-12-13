package com.pluralsight;

import org.apache.commons.dbcp2.BasicDataSource;

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

        try (BasicDataSource dataSource = new BasicDataSource()){
            boolean repeat = true;
            do {
                System.out.print("""
                        \033[4;1mMAIN MENU\033[0m
                        What do you want to do?
                        1) Display all products
                        2) Display all customers
                        3) Display all categories
                        0) Exit
                        Select an option:\s""");
                String command = scanner.nextLine();
                if (!command.matches("[123]")) {
                    System.out.println("Goodbye...");
                    repeat = false;
                } else {
                    dataSource.setUrl("jdbc:mysql://localhost:3306/northwind");
                    dataSource.setUsername(username);
                    dataSource.setPassword(password);
                    try (Connection connection = dataSource.getConnection()) {
                        switch (command) {
                            case "1" -> displayAllProducts(connection);
                            case "2" -> displayAllCustomers(connection);
                            case "3" -> categorySearch(connection, scanner);
                        }
                    } catch (Exception e) {
                        System.out.println("Cannot connect to SQL Database!");
                        e.printStackTrace();
                    }
                }
            }while (repeat);
        }
        catch (Exception e){
            System.out.println("Cannot load DataSource driver!");
            e.printStackTrace();
        }
    }


        public static void displayAllCustomers(Connection connection){

            try(PreparedStatement preparedStatement = connection.prepareStatement("SELECT ContactName, CompanyName, City, Country, Phone FROM customers ORDER BY Country;");
                ResultSet resultSet = preparedStatement.executeQuery()){
                System.out.println("\033[4;1mCUSTOMERS\033[0m");
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
                System.out.println("Cannot run customer display query!");
                e.printStackTrace();
            }
        }

        public static void displayAllProducts(Connection connection){
            try(PreparedStatement preparedStatement = connection.prepareStatement("SELECT ProductID, ProductName, UnitPrice, UnitsInStock FROM products ORDER BY ProductID;"); ResultSet resultSet = preparedStatement.executeQuery()){
                System.out.println("\033[4;1mPRODUCTS\033[0m");
                while (resultSet.next()) {
                    System.out.println("Product ID: " + resultSet.getString("ProductID"));
                    System.out.println("Product Name: " + resultSet.getString("ProductName"));
                    System.out.println("Unit Price: $" + resultSet.getString("UnitPrice"));
                    System.out.println("Units In Stock: " + resultSet.getString("UnitsInStock"));
                    System.out.println("===================================================");
                }
            }
            catch (Exception e) {
                System.out.println("Cannot run product display query!");
                e.printStackTrace();
            }
        }

        public static void categorySearch(Connection connection, Scanner scanner){
            try(PreparedStatement preparedStatement = connection.prepareStatement("SELECT CategoryID, CategoryName FROM categories ORDER BY CategoryID;");
                ResultSet resultSet = preparedStatement.executeQuery()){
                System.out.println("\033[4;1mCATEGORIES\033[0m");
                while (resultSet.next()) {
                    System.out.println(resultSet.getString(1) + ") "+ resultSet.getString(2));
                }
            }
            catch (Exception e) {
                System.out.println("Cannot run category lookup query!");
                e.printStackTrace();
                return;
            }
            System.out.print("Select a category to search: ");
            int toSearch = Integer.parseInt(scanner.nextLine());
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
            }
            catch (Exception e) {
                System.out.println("Cannot run category search query!");
                e.printStackTrace();
            }
        }

    }