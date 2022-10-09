package com.review_app.service;

import com.review_app.model.User;

public interface AuthService {

    User login(String username, String password);
}
