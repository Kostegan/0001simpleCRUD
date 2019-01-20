package com.junald.services;

import com.junald.model.UserDataSet;

import java.util.List;

public interface DBService {
    List<UserDataSet> getAllUsers();

    UserDataSet getUserById(int id);

    void deleteUser(int id);

    void addUser(UserDataSet userDataSet);

    void updateUser(UserDataSet userDataSet);
}
