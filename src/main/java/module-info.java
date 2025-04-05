module com.formapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.formapp to javafx.fxml;
    exports com.formapp;
    exports com.formapp.controller;
    opens com.formapp.controller to javafx.fxml;
}
