package com.example.sport_project_with_db.controllers;

import com.example.sport_project_with_db.HelloApplication;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class WindowForWeightCategory implements Initializable {

    @FXML

    private MenuItem add_weight_category_btn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        add_weight_category_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                Platform.runLater(() -> {
                    try {
                        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("fxml_files/weightCategoryView.fxml"));
                        Scene newscene = new Scene(loader.load());
                        Stage newstage = new Stage();
                        newstage.setScene(newscene);
                        newstage.setTitle("Добавить весовую категорию");
                        newstage.showAndWait();

                    }catch (Exception e){
                        System.out.println(e);
                    }
                });

            }
        });

    }
}
