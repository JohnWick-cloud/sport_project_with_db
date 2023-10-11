package com.example.sport_project_with_db.controllers;

import com.example.sport_project_with_db.HelloApplication;
import com.example.sport_project_with_db.classes_for_cntrollers.Sportsmen;
import com.example.sport_project_with_db.db_actions.sportsmenDb;
import javafx.application.Platform;
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
    private TableColumn<Sportsmen, String> act_col;

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
    private TableColumn<Sportsmen, String> reg_col;

    @FXML
    private TableColumn<Sportsmen, String> weight_col;




    public void updateData(){
            sportTable.getItems().clear();
            sportTable.setItems(sportsmenDb.getData());
            sportTable.refresh();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

//        act_col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Sportsmen, String>, ObservableValue<String>>() {
//            @Override
//            public ObservableValue<String> call(TableColumn.CellDataFeatures<Sportsmen, String> param) {
//                return new SimpleStringProperty(param.getValue().getAct());
//            }
//        });
//
//
//        age_col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Sportsmen, String>, ObservableValue<String>>() {
//            @Override
//            public ObservableValue<String> call(TableColumn.CellDataFeatures<Sportsmen, String> param) {
//                return new SimpleStringProperty(param.getValue().getAge_category());
//            }
//        });
//
//        club_col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Sportsmen, String>, ObservableValue<String>>() {
//            @Override
//            public ObservableValue<String> call(TableColumn.CellDataFeatures<Sportsmen, String> param) {
//                return new SimpleStringProperty(param.getValue().getSport_club());
//            }
//        });
//
//        weight_col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Sportsmen, String>, ObservableValue<String>>() {
//            @Override
//            public ObservableValue<String> call(TableColumn.CellDataFeatures<Sportsmen, String> param) {
//                return new SimpleStringProperty(param.getValue().getWeight());
//            }
//        });
//
//        reg_col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Sportsmen, String>, ObservableValue<String>>() {
//            @Override
//            public ObservableValue<String> call(TableColumn.CellDataFeatures<Sportsmen, String> param) {
//                return new SimpleStringProperty(param.getValue().getReg_num());
//            }
//        });

        name_col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Sportsmen, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Sportsmen, String> param) {
                return new SimpleStringProperty(param.getValue().getName());
            }
        });
        updateData();


//        gender_col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Sportsmen, String>, ObservableValue<String>>() {
//            @Override
//            public ObservableValue<String> call(TableColumn.CellDataFeatures<Sportsmen, String> param) {
//                return new SimpleStringProperty(param.getValue().getGender());
//            }
//        });
//
//        draw_col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Sportsmen, String>, ObservableValue<String>>() {
//            @Override
//            public ObservableValue<String> call(TableColumn.CellDataFeatures<Sportsmen, String> param) {
//                return new SimpleStringProperty(param.getValue().getDraw_num());
//            }
//        });
//
//        date_col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Sportsmen, String>, ObservableValue<String>>() {
//            @Override
//            public ObservableValue<String> call(TableColumn.CellDataFeatures<Sportsmen, String> param) {
//                return new SimpleStringProperty(param.getValue().getAge());
//            }
//        });



        addSportsmen.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Platform.runLater(() -> {
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
                });
            }
        });
    }
}