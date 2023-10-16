package com.example.sport_project_with_db.controllers;

import com.example.sport_project_with_db.HelloApplication;
import com.example.sport_project_with_db.classes_for_cntrollers.Sportsmen;
import com.example.sport_project_with_db.db_actions.sportsmenDb;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
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
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private MenuItem addSportClub;
    @FXML
    private MenuItem data_change;
    @FXML
    private MenuItem add_file_btn;

    @FXML
    private MenuItem weightCategory;

    @FXML
    private MenuItem addSportsmen;
    @FXML
    private  MenuItem ageCategory;

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
        TableView.TableViewSelectionModel<Sportsmen> selectionModel = sportTable.getSelectionModel();


        data_change.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("fxml_files/add_sportsmen.fxml"));
                    Scene newscene = new Scene(loader.load());
                    Stage newstage = new Stage();
                    AddSportsmen addSportsmen_controller = loader.getController();

                    addSportsmen_controller.update_sportsmen(selectionModel.getSelectedItem());


                    newstage.setScene(newscene);
                    newstage.setTitle("Добавить спортсмена");
                    newstage.showAndWait();


                }catch (Exception e){
                    System.out.println(e);
                }
            }
        });

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
        ageCategory.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Platform.runLater(() -> {
                    try {
                        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("fxml_files/ageCategoryView.fxml"));
                        Scene newscene = new Scene(loader.load());
                        Stage newstage = new Stage();
                        newstage.setScene(newscene);
                        newstage.setTitle("Добавить возрастную категорию");
                        newstage.showAndWait();

                    }catch (Exception e){
                        System.out.println(e);
                    }
                });
            }
        });


        addSportClub.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Platform.runLater(() -> {
                    try {
                        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("fxml_files/add_sportClub.fxml"));
                        Scene newscene = new Scene(loader.load());
                        Stage newstage = new Stage();
                        newstage.setScene(newscene);
                        newstage.setTitle("Добавить спортивный клуб");
                        newstage.showAndWait();

                    }catch (Exception e){
                        System.out.println(e);
                    }
                });
            }
        });

        weightCategory.setOnAction(new EventHandler<ActionEvent>() {
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

        add_file_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Выберите файл");

                FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Text files (*.txt)", "*.txt");
                fileChooser.getExtensionFilters().add(extFilter);
                // Установите фильтры для типов файлов, если это необходимо
                File selectedFile = fileChooser.showOpenDialog(new Stage());

                if (selectedFile != null) {
                    // Здесь можно выполнить действия с выбранным файлом
                    System.out.println("Выбран файл: " + selectedFile.getAbsolutePath());
                }
            }
        });
    }
}