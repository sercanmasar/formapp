package com.formapp.controller;

import com.formapp.model.User;
import com.formapp.service.UserService;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;
import java.util.stream.IntStream;

public class UserListController {

    @FXML private TableView<User> userTable;
    @FXML private TableColumn<User, Long> idCol;
    @FXML private TableColumn<User, String> firstNameCol;
    @FXML private TableColumn<User, String> lastNameCol;
    @FXML private TableColumn<User, String> emailCol;
    @FXML private TableColumn<User, String> phoneNumberCol;

    private final UserService userService = new UserService();

    @FXML
    public void initialize() {
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        phoneNumberCol.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));

        // Load users into the table
        loadUsers();
    }

    public void loadUsers() {
        List<User> users = userService.getAllUsers();
        userTable.getItems().setAll(users);
    }
}
