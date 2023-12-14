package com.pluralsight;

import org.apache.commons.dbcp2.BasicDataSource;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("We need a username and password to run the app");
            System.exit(1);
        }
        String username = args[0];
        String password = args[1];

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/northwind");
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        DataManager dataManager = new DataManager(dataSource);
        Scanner scanner = new Scanner(System.in);
        dataManager.insertNewShipper(scanner);
        dataManager.displayAllShippers();
        dataManager.changePhoneNumber(scanner);
        dataManager.deleteShipper(scanner);
    }
}
