package com.junald.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.junald.executor.Executor;
import com.junald.executor.ResultHandler;
import com.junald.model.UserDataSet;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class UserDAOImpl implements UserDAO {
    private Session session;

    public UserDAOImpl(Session session) {
        this.session = session;
    }

    @Override
    public void addUser(String name, String password, String login) throws SQLException {
        session.save(new UserDataSet(name, password, login));
    }

    @Override
    public void deleteUser(int userId) throws SQLException {
        UserDataSet tempUser = new UserDataSet();
        tempUser.setId(userId);
        session.delete(tempUser);
    }

    @Override
    public void updateUser(String name, String password, String login) throws SQLException {
        session.save(new UserDataSet(name, password, login));
    }

    @Override
    public UserDataSet getUserById(int userId) {
        return (UserDataSet) session.get(UserDataSet.class, userId);
    }

    @Override
    public List<UserDataSet> getAllUser() {
        Query query = session.createQuery("FROM UserDataSet");
        List<UserDataSet> list = (List<UserDataSet>) query.list();
        if (list != null) {
            for (UserDataSet user : list) {
                System.out.println(user.getName());
            }
        } else {
            System.out.println("List has null");
        }
        return list;
    }
}