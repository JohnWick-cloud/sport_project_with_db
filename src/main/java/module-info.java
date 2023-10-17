module com.example.sport_project_with_db {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;



    opens com.example.sport_project_with_db to javafx.fxml;
    exports com.example.sport_project_with_db;
    exports com.example.sport_project_with_db.db_actions;
    opens com.example.sport_project_with_db.db_actions to javafx.fxml;
    exports com.example.sport_project_with_db.controllers;
    opens com.example.sport_project_with_db.controllers to javafx.fxml;
    exports com.example.sport_project_with_db.classes_for_cntrollers;
    opens com.example.sport_project_with_db.classes_for_cntrollers to javafx.fxml;
}