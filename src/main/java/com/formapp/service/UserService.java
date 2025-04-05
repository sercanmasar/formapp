package com.formapp.service;

import com.formapp.model.User;
import com.formapp.util.DatabaseHelper;

import java.util.List;

public class UserService {
    public boolean saveUser(User user) {
        return DatabaseHelper.insertUser(user);
    }

    public List<User> getAllUsers() {
        return DatabaseHelper.getAllUsers();
    }
}
