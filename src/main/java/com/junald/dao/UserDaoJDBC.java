package com.junald.dao;

import com.junald.util.executor.Executor;
import com.junald.util.executor.ResultHandler;
import com.junald.model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBC implements UserDao {
    private Executor executor;
    private static Connection connection;

    public UserDaoJDBC(Connection connection) {
        this.connection = connection;
        this.executor = new Executor(connection);
    }

    @Override
    public void addUser(User user) {
        try {
            connection.setAutoCommit(false);
            String password = user.getPassword();
            String login = user.getLogin();
            String name = user.getName();
            executor.execUpdate("insert into user (name, password, login) values ('" + name + "','" + password + "','" + login + "')");
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ignore) {
            }
            System.err.println("Occurred SQL error");
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ignore) {
            }
        }
    }

    @Override
    public void deleteUser(int userId) {
        try {
            connection.setAutoCommit(false);
            executor.execUpdate("delete from user where id=" + userId);
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ignore) {
            }
            System.err.println("Occurred SQL error");
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ignore) {
            }
        }
    }

    @Override
    public void updateUser(User user) {
        try {
            connection.setAutoCommit(false);
            String name = user.getName();
            String password = user.getPassword();
            String login = user.getLogin();
            executor.execUpdate("update user set name='" + name + "', password='" + password + "', login='" + login + "' where id=" + user.getId());
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ignore) {
            }
            System.err.println("Occurred SQL error");
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ignore) {
            }
        }
    }

    @Override
    public List<User> getAllUser() {
        List<User> users = new ArrayList<>();
        try {
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
        } catch (SQLException e) {
            System.err.println("Occurred SQL error");
        }
        return users;
    }

    @Override
    public User getUserById(int userId) {
        try {
            return executor.execQuery("select * from user where id=" + userId, resultSet -> {
                if (resultSet.next()) {
                    return new User(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("password"), resultSet.getString("login"));
                }
                return null;   //todo уточнить
            });
        } catch (SQLException e) {
            System.err.println("Occurred SQL error");
        }
        return null;   //todo уточнить
    }
}
