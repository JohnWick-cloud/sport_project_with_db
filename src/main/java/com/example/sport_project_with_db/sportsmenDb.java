package com.example.sport_project_with_db;

import java.sql.*;

public class sportsmenDb {

    public static void write(String name){

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

        }catch (Exception e){
            System.out.println(e);
        }



    }
}
