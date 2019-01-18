package com.junald.dao;

import java.sql.SQLException;
import java.util.List;

import com.junald.model.User;

public interface UserDAO {
    public void addUser(User user) throws SQLException;

    public void deleteUser(int userId) throws SQLException;

    public void updateUser(User user) throws SQLException;

    public List<User> getAllUser() throws SQLException;

    public User getUserById(int userId) throws SQLException;
}
