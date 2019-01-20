package com.junald.services;

import com.junald.dao.UserDAO;
import com.junald.dao.UserDAOImpl;
import com.junald.model.UserDataSet;
import com.junald.util.DBHelper;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.sql.SQLException;
import java.util.List;

public class DBServiceImpl implements DBService {
    private static DBService dbService = new DBServiceImpl();
    private final SessionFactory sessionFactory;

    private DBServiceImpl() {
        Configuration configuration = DBHelper.getConfiguration();
        this.sessionFactory = DBHelper.createSessionFactory(configuration);
    }

    public static DBService getInstance() {
        return dbService;
    }

    @Override
    public List<UserDataSet> getAllUsers() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        UserDAO dao = new UserDAOImpl(session);
        List<UserDataSet> users = dao.getAllUser();
        transaction.commit();
        session.close();
        return users;
    }

    @Override
    public UserDataSet getUserById(int id) {
        UserDataSet userDataSet = null;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        UserDAO dao = new UserDAOImpl(session);
        userDataSet = dao.getUserById(id);
        transaction.commit();
        session.close();
        return userDataSet;
    }

    @Override
    public void deleteUser(int id) {
        try {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            UserDAO dao = new UserDAOImpl(session);
            dao.deleteUser(id);
            transaction.commit();
            session.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addUser(UserDataSet userDataSet) {
        try {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            UserDAO dao = new UserDAOImpl(session);
            dao.addUser(userDataSet.getName(), userDataSet.getPassword(), userDataSet.getLogin());
            transaction.commit();
            session.close();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @Override
    public void updateUser(UserDataSet userDataSet) {
        try {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            UserDAO dao = new UserDAOImpl(session);
            dao.updateUser(userDataSet.getName(), userDataSet.getPassword(), userDataSet.getLogin());
            transaction.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
