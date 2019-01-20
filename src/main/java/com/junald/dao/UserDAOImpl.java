package com.junald.dao;

import java.util.List;

import com.junald.model.UserDataSet;
import org.hibernate.Query;
import org.hibernate.Session;

public class UserDAOImpl implements UserDAO {
    private Session session;

    public UserDAOImpl(Session session) {
        this.session = session;
    }

    @Override
    public void addUser(String name, String password, String login) {
        session.save(new UserDataSet(name, password, login));
    }

    @Override
    public void deleteUser(int userId) {
        UserDataSet tempUser = new UserDataSet();
        tempUser.setId(userId);
        session.delete(tempUser);
    }

    @Override
    public void updateUser(String name, String password, String login) {
        session.save(new UserDataSet(name, password, login));
    }

    @Override
    public UserDataSet getUserById(int userId) {
        return (UserDataSet) session.get(UserDataSet.class, userId);
    }

    @Override
    public List<UserDataSet> getAllUser() {
        Query query = session.createQuery("FROM UserDataSet");
        return (List<UserDataSet>) query.list();
    }
}