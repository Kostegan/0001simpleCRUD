package com.junald.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.junald.executor.Executor;
import com.junald.executor.ResultHandler;
import com.junald.model.User;
import com.junald.util.DBHelper;

public class UserDAOImpl implements UserDAO {
    private final Executor executor;

    public UserDAOImpl(Connection connection) {
        executor = new Executor(connection);
    }

    @Override
    public void addUser(User user) throws SQLException {
        String name = user.getName();
        String password = user.getPassword();
        String login = user.getLogin();
        executor.execUpdate("insert into user (name, password, login) values ('" + name + "','" + password + "','" + login + "')");
    }

    @Override
    public void deleteUser(int userId) throws SQLException {
        executor.execUpdate("delete from user where id=" + userId);
    }

    @Override
    public void updateUser(User user) throws SQLException {
        String name = user.getName();
        String password = user.getPassword();
        String login = user.getLogin();
        executor.execUpdate("update user set name='" + name + "', password='" + password + "', login='" + login + "' where id=" + user.getId());
    }

    @Override
    public User getUserById(int userId) throws SQLException {
        return executor.execQuery("select * from user where id=" + userId, new ResultHandler<User>() {
            @Override
            public User handle(ResultSet resultSet) throws SQLException {
                if (resultSet.next()) {
                    return new User(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("password"), resultSet.getString("login"));
                }
                return null;   //todo уточнить
            }
        });
    }

    @Override
    public List<User> getAllUser() throws SQLException {
        List<User> users = new ArrayList<>();
        return executor.execQuery("select * from user", new ResultHandler<List<User>>() {
            @Override
            public List<User> handle(ResultSet resultSet) throws SQLException {
                while (resultSet.next()) {
                    User user = new User();
                    user.setId(resultSet.getInt("id"));
                    user.setName(resultSet.getString("name"));
                    user.setPassword(resultSet.getString("password"));
                    user.setLogin(resultSet.getString("login"));
                    users.add(user);
                }
                return users;
            }
        });
    }
}