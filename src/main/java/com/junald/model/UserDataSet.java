package com.junald.model;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class UserDataSet {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;
    @Column(name = "password")
    private String password;
    @Column(name = "login")
    private String login;

    public UserDataSet() {
    }



    public UserDataSet(int id, String name, String password, String login) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.login = login;
    }

    public UserDataSet(String name, String password, String login) {
        this.name = name;
        this.password = password;
        this.login = login;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String toString() {
        return "UserDataSet [id=" + id + ", name=" + name
                + ", password=" + password + ", login=" + login
                + "]";
    }

}
