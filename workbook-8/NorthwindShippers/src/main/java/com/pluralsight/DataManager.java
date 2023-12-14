package com.pluralsight;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Scanner;

public class DataManager {
    /*---------------VARIABLES---------------*/

    private DataSource dataSource;

    /*--------------CONSTRUCTORS-------------*/

    public DataManager(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /*------------GETTERS/SETTERS------------*/



    /*---------------FUNCTIONS---------------*/


    public void insertNewShipper(Scanner scanner){
        System.out.println("Please type the name of the shipping company to add:");
        String companyToAdd = scanner.nextLine();
        System.out.println("Please type the phone number of the shipping company to add:");
        String phoneToAdd = scanner.nextLine();

        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO shippers (CompanyName, Phone) VALUES (? , ?);", Statement.RETURN_GENERATED_KEYS)){
            preparedStatement.setString(1, companyToAdd);
            preparedStatement.setString(2, phoneToAdd);

            int rows = preparedStatement.executeUpdate();
            System.out.printf("Rows updated: %d%n", rows);
            try (ResultSet keys = preparedStatement.getGeneratedKeys()
            ) {
                while (keys.next()) {
                    System.out.printf("Key %d was added%n",
                            keys.getInt(1));
                    System.out.println("==================================");
                }
                displayAllShippers();
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    public void displayAllShippers(){
        System.out.println("\nDisplaying all shippers...");
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM shippers");
            ResultSet resultSet = preparedStatement.executeQuery()){
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String phone = resultSet.getString(3);
                System.out.printf("Shipper ID: %d%nShipper Name: %s%nShipper Phone: %s%n==================================%n", id, name, phone);
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void changePhoneNumber(Scanner scanner){
        System.out.println("Please type the ID of the Shipper you'd like to adjust:");
        int idToFind = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Please type the new phone number for the shipper:");
        String newPhone = scanner.nextLine();

        try(Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE shippers SET Phone = ? WHERE ShipperID = ?")){
            preparedStatement.setString(1, newPhone);
            preparedStatement.setInt(2, idToFind);

            int rows = preparedStatement.executeUpdate();
            System.out.println(rows + " rows updated");
            System.out.println("==================================");
            displayAllShippers();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public void deleteShipper(Scanner scanner){
        System.out.println("Please type the ID of the shipper you would like to delete: ");
        int idToDelete = scanner.nextInt();
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM shippers WHERE ShipperID = ?")){
            preparedStatement.setInt(1, idToDelete);
            int rows = preparedStatement.executeUpdate();
            System.out.println(rows + " rows deleted");
            System.out.println("==================================");
            displayAllShippers();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
