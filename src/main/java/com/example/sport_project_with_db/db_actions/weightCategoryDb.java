package com.example.sport_project_with_db.db_actions;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class weightCategoryDb {

    public static void addWeight(String club){
        String url = "jdbc:postgresql://192.168.0.113:5432/SportProg";
        String login = "progers";
        String password = "root";
        String query = "INSERT INTO weight_category(weight) VALUES(?)";

        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url, login, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, club);
            preparedStatement.executeUpdate();

        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static ObservableList<String> getWeight(){
        String url = "jdbc:postgresql://192.168.0.113:5432/SportProg";
        String login = "progers";
        String password = "root";
        ObservableList<String> data = FXCollections.observableArrayList();
        try(Connection connection = DriverManager.getConnection(url, login, password)){
            String query = "SELECT weight FROM weight_category";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String weight = resultSet.getString("weight");
                data.add(weight);
            }
            return data;
        }catch (Exception e){
            System.out.println(e);
        }
        return data;
    }

    public static String getFirst(){

        String url = "jdbc:postgresql://192.168.0.113:5432/SportProg";
        String login = "progers";
        String password = "root";
        String data = "";
        try(Connection connection = DriverManager.getConnection(url, login, password)){
            String query = "SELECT weight FROM weight_category";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                String weight = resultSet.getString("weight");
                data = weight;
            }

            return data;
        }catch (Exception e){
            System.out.println(e);
        }
        return data;
    }

}
