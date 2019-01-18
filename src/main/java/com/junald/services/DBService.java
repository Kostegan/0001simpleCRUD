package com.junald.services;

import com.junald.model.User;

import java.util.List;

public interface DBService {
    public List<User> getAllUsers();

    public User getUserById(int id);

    public void deleteUser(int id);

    public void addUser(User user);

    public void updateUser(User user);
}
