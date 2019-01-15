package com.junald.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.junald.model.Student;
import com.junald.util.DBUtil;

public class UserDAOImpl implements UserDAO {

    private Connection conn;

    public UserDAOImpl() {
        conn = DBUtil.getConnection();
    }
    @Override
    public void addStudent( Student student ) {
        try {
            String query = "insert into student (name, password, login) values (?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement( query );
            preparedStatement.setString( 1, student.getName() );
            preparedStatement.setString( 2, student.getPassword() );
            preparedStatement.setString(3, student.getLogin());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void deleteStudent( int studentId ) {
        try {
            String query = "delete from student where id=?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, studentId);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void updateStudent( Student student ) {
        try {
            String query = "update student set name=?, password=?, login=? where id=?";
            PreparedStatement preparedStatement = conn.prepareStatement( query );
            preparedStatement.setString( 1, student.getName() );
            preparedStatement.setString( 2, student.getPassword() );
            preparedStatement.setString(3, student.getLogin());
            preparedStatement.setInt(4, student.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery( "select * from student" );
            while( resultSet.next() ) {
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setPassword(resultSet.getString("password"));
                student.setLogin(resultSet.getString("login"));
                students.add(student);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
    @Override
    public Student getStudentById(int studentId) {
        Student student = new Student();
        try {
            String query = "select * from student where id=?";
            PreparedStatement preparedStatement = conn.prepareStatement( query );
            preparedStatement.setInt(1, studentId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while( resultSet.next() ) {
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setPassword(resultSet.getString("password"));
                student.setLogin(resultSet.getString("login"));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

}