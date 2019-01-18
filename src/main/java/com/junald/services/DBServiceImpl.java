package com.junald.services;

import com.junald.dao.UserDAO;
import com.junald.dao.UserDAOImpl;
import com.junald.model.User;
import com.junald.util.DBHelper;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class DBServiceImpl implements DBService {
    private static DBService dbService = new DBServiceImpl();
    private final Connection connection;                //todo уточнить
    private final UserDAO userDAO;

    private DBServiceImpl() {
        connection = DBHelper.getConnection();
        userDAO = new UserDAOImpl(connection);
    }

    public static DBService getInstance() {
        return dbService;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> list = null;                        //todo уточнить
        try {
            return userDAO.getAllUser();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

//    @Override
//    public List<User> getAllUsers() {         //todo уточнить
//        try {
//            return userDAO.getAllUser();
//        } catch (SQLException e) {
//            throw new IllegalArgumentException();
//        }
//    }

    @Override
    public User getUserById(int id) {
        User user = null;
        try {
            return userDAO.getUserById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void deleteUser(int id) {
        try {
            connection.setAutoCommit(false);
            userDAO.deleteUser(id);
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addUser(User user) {
        try {
            connection.setAutoCommit(false);  //todo уточнить
            userDAO.addUser(user);
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateUser(User user) {
        try {
            userDAO.updateUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
