package com.review_app.service;

import com.review_app.model.Role;
import com.review_app.model.User;

public interface UserService {

    User register(String username, String password, String repeatPassword, String name, String surname, Role role);
}
