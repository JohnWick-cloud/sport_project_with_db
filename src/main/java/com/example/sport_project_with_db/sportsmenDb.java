package com.example.sport_project_with_db;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;

import java.sql.*;

public class sportsmenDb {

    public static void write(String name){
        ObservableList<Sportsmen> data = FXCollections.observableArrayList();
        String url = "jdbc:postgresql://localhost:5432/sportsmens_list";
        String login = "postgres";
        String password = "postgres";
        String query = "INSERT INTO sportsmens(name) VALUES(?)";

        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url, login, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
            data.add(new Sportsmen(name));



        }catch (Exception e){
            System.out.println(e);
        }

    }

    public static ObservableList<Sportsmen> getData(){
        String url = "jdbc:postgresql://localhost:5432/sportsmens_list";
        String login = "postgres";
        String password = "postgres";
        ObservableList<Sportsmen> data = FXCollections.observableArrayList();
        try(Connection connection = DriverManager.getConnection(url, login, password)){
            String query = "SELECT name FROM sportsmens";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                String name = resultSet.getString("name");
                data.add(new Sportsmen(name));
            }

            return data;

        }catch (Exception e){
            System.out.println(e);
        }
        return data;
    }
}
