package com.example.sport_project_with_db;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AddSportsmen implements Initializable {
    @FXML
    Button confirm_btn;
    @FXML
    TextField name_field;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        confirm_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String name = name_field.getText();
                try {
                    sportsmenDb.write(name);
                    Stage stage = (Stage) confirm_btn.getScene().getWindow();
                    stage.close();

                }catch (Exception e){
                    System.out.println(e.getMessage());
                }

            }
        });
    }
}
