package com.example.sport_project_with_db.controllers;

import com.example.sport_project_with_db.HelloApplication;
import com.example.sport_project_with_db.classes_for_cntrollers.Sportsmen;
import com.example.sport_project_with_db.db_actions.sportsmenDb;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private MenuItem addSportsmen;

    @FXML
    private TableView<Sportsmen> sportTable;

    @FXML
    private TableColumn<Sportsmen, String> age_col;

    @FXML
    private TableColumn<Sportsmen, Boolean> act_col;

    @FXML
    private TableColumn<Sportsmen, String> club_col;

    @FXML
    private TableColumn<Sportsmen, String> date_col;

    @FXML
    private TableColumn<Sportsmen, String> draw_col;

    @FXML
    private TableColumn<Sportsmen, String> gender_col;

    @FXML
    private TableColumn<Sportsmen, String> name_col;

    @FXML
    private TableColumn<Sportsmen, Integer> reg_col;

    @FXML
    private TableColumn<Sportsmen, String> weight_col;




    public void updateData(){
            sportTable.getItems().clear();
            sportTable.setItems(sportsmenDb.getData());
            sportTable.refresh();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        weight_col.setCellValueFactory(new PropertyValueFactory<>("weight"));
        reg_col.setCellValueFactory(new PropertyValueFactory<>("reg_num"));
        age_col.setCellValueFactory(new PropertyValueFactory<>("age_category"));
        name_col.setCellValueFactory(new PropertyValueFactory<>("name"));
        gender_col.setCellValueFactory(new PropertyValueFactory<>("gender"));
        draw_col.setCellValueFactory(new PropertyValueFactory<>("draw_num"));
        date_col.setCellValueFactory(new PropertyValueFactory<>("age"));
        club_col.setCellValueFactory(new PropertyValueFactory<>("sport_club"));
        act_col.setCellValueFactory(new PropertyValueFactory<>("act"));

        updateData();


        addSportsmen.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                    try {
                        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("fxml_files/add_sportsmen.fxml"));
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