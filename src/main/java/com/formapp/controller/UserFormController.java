package com.formapp.controller;


import com.formapp.model.User;
import com.formapp.service.UserService;
import com.formapp.util.SceneManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class UserFormController {

    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField phoneNumberField;
    @FXML
    private Label statusLabel;

    private final UserService userService = new UserService();

    @FXML
    public void handleRegister() {
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String email = emailField.getText();
        String phone = phoneNumberField.getText();

        User user = new User(null, firstName, lastName, email, phone);
        boolean success = userService.saveUser(user);

        if (success) {
            statusLabel.setText("User registered successfully.");
            clearFields();
        } else {
            statusLabel.setText("Failed to register user.");
        }

        handleGoToUserList();
    }

    @FXML
    private void handleGoToUserList() {
        SceneManager.switchScene("/com/formapp/user-list.fxml", "User List");
    }

    private void clearFields() {
        firstNameField.clear();
        lastNameField.clear();
        emailField.clear();
        phoneNumberField.clear();
    }
}

