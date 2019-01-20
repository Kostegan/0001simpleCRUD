package com.junald.dao;

import java.util.List;

import com.junald.model.UserDataSet;

public interface UserDAO {
    void addUser(String name, String password, String login);

    void deleteUser(int userId);

    void updateUser(String name, String password, String login);

    List<UserDataSet> getAllUser();

    UserDataSet getUserById(int userId);
}
