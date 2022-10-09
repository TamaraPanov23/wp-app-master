package com.review_app.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "app_users")
public class User {

    @Id
    private String username;

    private String name;

    private String surname;

    private String password;

    @Enumerated(value = EnumType.STRING)
    private Role role;

    public User() {
    }

    public User(String username, String name, String surname, String password, Role role) {
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.role = role;
    }
}
