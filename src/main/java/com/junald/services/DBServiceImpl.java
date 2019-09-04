package com.junald.services;

import com.junald.dao.UserDao;
import com.junald.dao.UserDaoFactory;
import com.junald.model.User;

import java.util.List;

public class DBServiceImpl implements DBService {
    private static volatile DBService instance;
    private static final UserDao dao = UserDaoFactory.getUserDao();

    private DBServiceImpl() {
    }

    public static DBService getInstance() {
        DBService localInstance = instance;
        if (localInstance == null) {
            synchronized (DBService.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new DBServiceImpl();
                }
            }
        }
        return localInstance;
    }

    @Override
    public int getUserId(String login) {
        return dao.getUserId(login);
    }

    @Override
    public List<User> getAllUsers() {
        return dao.getAllUser();

    }

    @Override
    public User getUserById(int id) {
        return dao.getUserById(id);
    }

    @Override
    public void deleteUser(int id) {
        dao.deleteUser(id);
    }

    @Override
    public void addUser(User user) {
        dao.addUser(user);
    }

    @Override
    public void updateUser(User user) {
        dao.updateUser(user);
    }
}
