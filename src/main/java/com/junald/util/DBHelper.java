package com.junald.util;

import com.junald.dao.UserDaoHibernate;
import com.junald.dao.UserDaoJDBC;
import com.junald.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBHelper {

    public static UserDaoJDBC getUserDaoJDBC() {
        return new UserDaoJDBC(getMysqlConnection());
    }

    public static UserDaoHibernate getUserDaoHibernate() {
        return new UserDaoHibernate(createSessionFactory(getHibernateConfiguration()));
    }


    public static Connection getMysqlConnection() {
        Connection conn = null;
        InputStream inputStream = DBHelper.class.getClassLoader().getResourceAsStream("/JDBC.properties");
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
            String driver = properties.getProperty("driver");
            String url = properties.getProperty("url");
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    private static Configuration getHibernateConfiguration() {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(User.class);
        InputStream inputStream = DBHelper.class.getClassLoader().getResourceAsStream("/Hibernate.properties");
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
            configuration.setProperty("hibernate.dialect", properties.getProperty("h.dialect"));
            configuration.setProperty("hibernate.connection.driver_class", properties.getProperty("h.driver_class"));
            configuration.setProperty("hibernate.connection.url", properties.getProperty("h.url"));
            configuration.setProperty("hibernate.connection.username", properties.getProperty("h.username"));
            configuration.setProperty("hibernate.connection.password", properties.getProperty("h.password"));
            configuration.setProperty("hibernate.show_sql", properties.getProperty("h.hibernate.show_sql"));
            configuration.setProperty("hibernate.hbm2ddl.auto", properties.getProperty("h.hbm2ddl.auto"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return configuration;
    }

    private static SessionFactory createSessionFactory(Configuration configuration) {
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(configuration.getProperties());
        ServiceRegistry serviceRegistry = builder.build();
        return configuration.buildSessionFactory(serviceRegistry);
    }
}
