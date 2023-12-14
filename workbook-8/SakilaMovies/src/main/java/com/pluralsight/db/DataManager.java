package com.pluralsight.db;
import com.pluralsight.models.*;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
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

    public List<Actor> searchByLastName(Scanner scanner) {
        List<Actor> actors = new ArrayList<>();

        System.out.print("Enter the last name of the actor to search for: ");
        String lastName = scanner.nextLine();

        try (   Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT actor_id, first_name, last_name FROM actor WHERE last_name LIKE ?")) {
            preparedStatement.setString(1, lastName);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()){
                    int id = resultSet.getInt(1);
                    String first = resultSet.getString(2);
                    String last = resultSet.getString(3);
                    Actor actor = new Actor(id, first, last);
                    actors.add(actor);
                }
            }
        } catch (Exception e) {
            System.out.println("Cannot run last name search query!");
            e.printStackTrace();
        }
        return actors;
    }


    public List<Film> searchForFilm(Scanner scanner) {
        ArrayList<Film> films = new ArrayList<>();

        System.out.print("Enter the id of the actor to search for: ");
        int idToSearch = scanner.nextInt();

        try (   Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("""
                SELECT f.film_id, title, description, release_year, length FROM film f
                JOIN film_actor fa ON f.film_id = fa.film_id
                WHERE fa.actor_id LIKE ?""")) {
            preparedStatement.setInt(1, idToSearch);


            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()){
                    int id = resultSet.getInt(1);
                    String title = resultSet.getString(2);
                    String description = resultSet.getString(3);
                    int release = resultSet.getInt(4);
                    int duration = resultSet.getInt(5);
                    Film film = new Film(id, title, description, release, duration);
                    films.add(film);
                }
            }
        } catch (Exception e) {
            System.out.println("Cannot run movie search query!");
            e.printStackTrace();
        }
        return films;
    }
}
