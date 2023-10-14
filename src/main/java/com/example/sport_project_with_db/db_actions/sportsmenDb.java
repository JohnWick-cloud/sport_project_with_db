package com.example.sport_project_with_db.db_actions;

import com.example.sport_project_with_db.classes_for_cntrollers.Sportsmen;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.time.LocalDate;

public class sportsmenDb {

    public static void write(String name, int cod_reg, int cod_draw, String age, String club, String gender, boolean action, String weight, String age_category){
        ObservableList<Sportsmen> data = FXCollections.observableArrayList();
        String url = "jdbc:postgresql://192.168.0.113:5432/SportProg";
        String login = "progers";
        String password = "root";
        String query = "INSERT INTO sportsmens(name, cod_reg, cod_draw, age, club, gender, action, weight, age_category) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url, login, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, cod_reg);
            preparedStatement.setInt(3, cod_draw);
            preparedStatement.setDate(4, java.sql.Date.valueOf(age));
            preparedStatement.setString(5, club);
            preparedStatement.setString(6, gender);
            preparedStatement.setBoolean(7, action);
            preparedStatement.setString(8, weight);
            preparedStatement.setString(9, age);
            preparedStatement.executeUpdate();
            data.add(new Sportsmen(name, club, gender, weight, age_category, age, cod_draw, cod_reg, action));



        }catch (Exception e){
            System.out.println(e);
        }

    }

    public static ObservableList<Sportsmen> getData(){
        String url = "jdbc:postgresql://192.168.0.113:5432/SportProg";
        String login = "progers";
        String password = "root";
        ObservableList<Sportsmen> data = FXCollections.observableArrayList();
        try(Connection connection = DriverManager.getConnection(url, login, password)){
            String query = "SELECT name, cod_reg, cod_draw, age, club, gender, action, weight, age_category FROM sportsmens";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                String name = resultSet.getString("name");
                int cod_reg = resultSet.getInt("cod_reg");
                int cod_draw = resultSet.getInt("cod_draw");
                Date age = resultSet.getDate("age");
                String club = resultSet.getString("club");
                String gender = resultSet.getString("gender");
                boolean action = resultSet.getBoolean("action");
                String weight = resultSet.getString("weight");
                String age_category = resultSet.getString("age_category");
                data.add(new Sportsmen(name, club, gender, weight, age_category, age.toString(), cod_draw, cod_reg, action));
            }

            return data;

        }catch (Exception e){
            System.out.println(e);
        }
        return data;
    }
}
