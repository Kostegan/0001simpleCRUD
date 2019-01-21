package com.junald.dao;

import java.sql.SQLException;
import java.util.List;

import com.junald.model.User;

public interface UserDAO {
    void addUser(User user) throws SQLException;

    void deleteUser(int userId) throws SQLException;

    void updateUser(User user) throws SQLException;

    List<User> getAllUser() throws SQLException;

    User getUserById(int userId) throws SQLException;
}
