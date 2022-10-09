package com.review_app.service.Impl;

import com.review_app.model.Role;
import com.review_app.model.User;
import com.review_app.model.exceptions.InvalidUsernameOrPasswordException;
import com.review_app.model.exceptions.PasswordsDoNotMatchException;
import com.review_app.model.exceptions.UsernameAlreadyExistsException;
import com.review_app.repository.UserRepository;
import com.review_app.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User register(String username, String password, String repeatPassword, String name, String surname, Role userRole) {

        if (username==null || username.isEmpty()  || password==null || password.isEmpty())
            throw new InvalidUsernameOrPasswordException();
        if (!password.equals(repeatPassword))
            throw new PasswordsDoNotMatchException();
        if(this.userRepository.findByUsername(username).isPresent())
            throw new UsernameAlreadyExistsException(username);
        User user = new User(username,passwordEncoder.encode(password),name,surname,userRole);

        return userRepository.save(user);
    }
}
