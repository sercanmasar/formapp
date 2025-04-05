module com.formapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    exports com.formapp;
    exports com.formapp.controller;

    opens com.formapp to javafx.fxml;
    opens com.formapp.controller to javafx.fxml;
    opens com.formapp.model to javafx.base;
}
