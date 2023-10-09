module com.example.sport_project_with_db {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.sport_project_with_db to javafx.fxml;
    exports com.example.sport_project_with_db;
}