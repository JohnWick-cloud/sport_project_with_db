package com.example.sport_project_with_db.db_actions;

import com.example.sport_project_with_db.classes_for_cntrollers.Sportsmen;
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
        String query = "INSERT INTO sportClubs(club) VALUES(?)";

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

//    public static ObservableList<String> getSportClub(){
//        String url = "jdbc:postgresql://192.168.0.113:5432/SportProg";
//        String login = "progers";
//        String password = "root";
//        ObservableList<Sportsmen> data = FXCollections.observableArrayList();
//        try(Connection connection = DriverManager.getConnection(url, login, password)){
//            String query = "SELECT club FROM sportsmens";
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            ResultSet resultSet = preparedStatement.executeQuery();
//
//            while (resultSet.next()){
//                String name = resultSet.getString("name");
//                data.add(new Sportsmen(name));
//            }
//
//            return data;
//
//        }catch (Exception e){
//            System.out.println(e);
//        }
//        return data;
//    }
}
