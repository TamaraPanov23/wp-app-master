package com.review_app.service.Impl;


import com.review_app.model.User;
import com.review_app.model.exceptions.InvalidArgumentsException;
import com.review_app.model.exceptions.InvalidUserCredentialsException;
import com.review_app.repository.UserRepository;
import com.review_app.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User login(String username, String password) {
        if (username==null || username.isEmpty() || password==null || password.isEmpty()){
            throw new InvalidArgumentsException();
        }

        return userRepository.findByUsernameAndPassword(username, password)
                .orElseThrow(InvalidUserCredentialsException::new);
    }
}
