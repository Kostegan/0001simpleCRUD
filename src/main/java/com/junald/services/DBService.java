package com.junald.services;

import com.junald.model.User;

import java.util.List;

public interface DBService {
    List<User> getAllUsers();

    int getUserId(String login);

    User getUserById(int id);

    void deleteUser(int id);

    void addUser(User user);

    void updateUser(User user);
}
