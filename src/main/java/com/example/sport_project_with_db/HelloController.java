package com.example.sport_project_with_db;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private MenuItem addSportsmen;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        addSportsmen.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/add_sportsmen.fxml"));
                    Scene newscene = new Scene(loader.load());
                    Stage newstage = new Stage();
                    newstage.setScene(newscene);
                    newstage.setTitle("Добавить спортсмена");
                    newstage.showAndWait();

                }catch (Exception e){
                    System.out.println(e);
                }
            }
        });
    }
}