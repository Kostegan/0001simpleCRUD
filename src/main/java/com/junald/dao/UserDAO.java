package com.junald.dao;

import java.util.List;

import com.junald.model.User;

public interface UserDAO {
    public void addStudent( User user);
    public void deleteStudent( int studentId );
    public void updateStudent( User user);
    public List<User> getAllStudents();
    public User getStudentById(int studentId );
}
