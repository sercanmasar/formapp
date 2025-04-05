package com.formapp.model;

import javafx.beans.property.SimpleStringProperty;

public class User {

    private final SimpleStringProperty id = new SimpleStringProperty();
    private final SimpleStringProperty firstName = new SimpleStringProperty();
    private final SimpleStringProperty lastName = new SimpleStringProperty();
    private final SimpleStringProperty email = new SimpleStringProperty();
    private final SimpleStringProperty phoneNumber = new SimpleStringProperty();

    // Constructor
    public User(String id,String firstName, String lastName, String email, String phoneNumber) {
        this.id.set(String.valueOf(id));
        this.firstName.set(firstName);
        this.lastName.set(lastName);
        this.email.set(email);
        this.phoneNumber.set(phoneNumber);

    }

    // Getters
    public String getId() { return id.get(); }
    public String getFirstName() { return firstName.get(); }
    public String getLastName() { return lastName.get(); }
    public String getEmail() { return email.get(); }
    public String getPhoneNumber() { return phoneNumber.get(); }

    // Property Getters (needed by JavaFX TableView)

    public SimpleStringProperty idProperty() { return id; }
    public SimpleStringProperty firstNameProperty(String firstName) { return this.firstName; }
    public SimpleStringProperty lastNameProperty() { return lastName; }
    public SimpleStringProperty emailProperty() { return email; }
    public SimpleStringProperty phoneNumberProperty() { return phoneNumber; }

}
