package com.pluralsight;
import com.pluralsight.db.DataManager;
import com.pluralsight.models.*;

import org.apache.commons.dbcp2.BasicDataSource;
import java.util.List;
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
        dataSource.setUrl("jdbc:mysql://localhost:3306/sakila");
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        DataManager dataManager = new DataManager(dataSource);

        Scanner scanner = new Scanner(System.in);


            List<Actor> actorList = dataManager.searchByLastName(scanner);
            if(!actorList.isEmpty()){
                System.out.println("Actors found!");
                for (Actor actor: actorList) {
                    actor.printInfo();
                }
            }
            else {
                System.out.println("No actors found with given last name!");
            }
            List<Film> filmList = dataManager.searchForFilm(scanner);
        if(!filmList.isEmpty()){
            System.out.println("Films found!");
            for (Film film: filmList) {
                film.printInfo();
            }
        }
        else {
            System.out.println("No films found with given actor ID!");
        }
    }




}
