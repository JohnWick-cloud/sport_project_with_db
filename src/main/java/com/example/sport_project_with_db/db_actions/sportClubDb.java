package com.example.sport_project_with_db.db_actions;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class sportClubDb {
    public static void addSportCLub(String club){
        String url = "jdbc:postgresql://192.168.0.113:5432/SportProg";
        String login = "progers";
        String password = "root";
        String query = "INSERT INTO sportclub(club) VALUES(?)";

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

    public static ObservableList<String> getSportClub(){
        String url = "jdbc:postgresql://192.168.0.113:5432/SportProg";
        String login = "progers";
        String password = "root";
        ObservableList<String> data = FXCollections.observableArrayList();
        try(Connection connection = DriverManager.getConnection(url, login, password)){
            String query = "SELECT club FROM sportclub";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String club = resultSet.getString("club");
                data.add(club);
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
            String query = "SELECT club FROM sportclub";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                String club = resultSet.getString("club");
                data = club;
            }

            return data;
        }catch (Exception e){
            System.out.println(e);
        }
        return data;
    }
}
