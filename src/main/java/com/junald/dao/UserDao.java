package com.junald.dao;

import java.util.List;

import com.junald.model.User;

public interface UserDao {
    void addUser(User user);

    void deleteUser(int userId);

    void updateUser(User user);

    List<User> getAllUser();

    User getUserById(int userId);

    int getUserId(String login);
}
