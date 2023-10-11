package com.example.sport_project_with_db.controllers;
import com.example.sport_project_with_db.db_actions.sportsmenDb;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

import java.net.URL;
import java.util.ResourceBundle;

public class AddSportsmen implements Initializable {
    @FXML
    Button confirm_btn;
    @FXML
    TextField name_field;

    @FXML
    private ToggleGroup action;

    @FXML
    private RadioButton action_yes;

    @FXML
    private RadioButton actoin_no;

    @FXML
    private ComboBox<String> age_choice;

    @FXML
    private DatePicker birthDate_choice;

    @FXML
    private TextField draw_field;

    @FXML
    private ComboBox<String> genderChoice;

    @FXML
    private TextField reg_field;

    @FXML
    private ComboBox<String> sportClub_choice;

    @FXML
    private ComboBox<String> weight_choice;



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        boolean action_ = true;
        if(actoin_no.isSelected()){
            action_ = false;
        }



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
