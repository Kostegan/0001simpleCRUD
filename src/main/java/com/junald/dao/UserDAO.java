package com.junald.dao;

import java.sql.SQLException;
import java.util.List;

import com.junald.model.UserDataSet;
import com.junald.model.UserDataSet;

public interface UserDAO {
    public void addUser(String name,String password, String login) throws SQLException;

    public void deleteUser(int userId) throws SQLException;

    public void updateUser(String name,String password, String login) throws SQLException;

    public List<UserDataSet> getAllUser();

    public UserDataSet getUserById(int userId);
}
