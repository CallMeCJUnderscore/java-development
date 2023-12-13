package com.pluralsight;

import org.apache.commons.dbcp2.BasicDataSource;
import java.sql.*;
import java.util.Scanner;
public class Program {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("We need a username and password to run the app");
            System.exit(1);
        }
        String username = args[0];
        String password = args[1];


        Scanner scanner = new Scanner(System.in);

        try (BasicDataSource dataSource = new BasicDataSource();
             Connection connection = dataSource.getConnection()) {
            dataSource.setUrl("jdbc:mysql://localhost:3306/sakila");
            dataSource.setUsername(username);
            dataSource.setPassword(password);
            searchByLastName(connection, scanner);
            searchForMovie(connection, scanner);
        } catch (Exception e) {
            System.out.println("Cannot connect to SQL Database!");
            e.printStackTrace();
        }
    }

    public static void searchByLastName(Connection connection, Scanner scanner) {
        System.out.print("Enter the last name of the actor to search for: ");
        String lastName = scanner.nextLine();

        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT first_name, last_name FROM actor WHERE last_name LIKE ?")) {
            preparedStatement.setString(1, lastName);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (!resultSet.next()) {
                    System.out.println("No actors found with that last name!");
                } else {
                    System.out.println("Actors found!\n=========================");
                    do {
                        System.out.println("First Name: " + resultSet.getString(1));
                        System.out.println("Last Name: " + resultSet.getString(2));
                        System.out.println("=========================");
                    } while (resultSet.next());
                }
            }
        } catch (Exception e) {
            System.out.println("Cannot run last name search query!");
            e.printStackTrace();
        }
    }

    public static void searchForMovie(Connection connection, Scanner scanner) {
        System.out.print("Enter the first name of the actor to search for: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter the first name of the actor to search for: ");
        String lastName = scanner.nextLine();
        try (PreparedStatement preparedStatement = connection.prepareStatement("""
                SELECT title FROM film f
                JOIN film_actor fa ON f.film_id = fa.film_id
                JOIN actor a ON fa.actor_id = fa.film_id
                WHERE a.first_name LIKE ? AND a.last_name LIKE ?""")) {
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (!resultSet.next()) {
                    System.out.println("No movies found with that name!");
                } else {
                    System.out.println("Movies found!\n=========================");
                    do {
                        System.out.println(resultSet.getString(1));
                    } while (resultSet.next());
                }
            }

        } catch (Exception e) {
            System.out.println("Cannot run movie search query!");
            e.printStackTrace();
        }
    }
}
