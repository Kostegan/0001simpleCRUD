package com.junald.dao;

import com.junald.util.DBHelper;

import java.io.IOException;
import java.util.Properties;

public class UserDaoFactory {
    public static UserDao getUserDao() {
        String name = null;
        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            Properties prop = new Properties();
            prop.load(classLoader.getResourceAsStream("/dbConfig.properties"));
            name = prop.getProperty("db.access");
        } catch (IOException e) {
            e.printStackTrace();
        }
        switch (name) {
            case "JDBC": {
                return DBHelper.getUserDaoJDBC();
            }
            case "Hibernate": {
                return DBHelper.getUserDaoHibernate();
            }
            default: {
                return null;
            }
        }
    }
}
