package com.formapp.service;

import com.formapp.model.User;
import com.formapp.util.DatabaseHelper;

public class UserService {
    public boolean saveUser(User user) {
        return DatabaseHelper.insertUser(user);
    }
}
