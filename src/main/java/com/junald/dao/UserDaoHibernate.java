package com.junald.dao;

import com.junald.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class UserDaoHibernate implements UserDao {
    private final SessionFactory sessionFactory;

    public UserDaoHibernate(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addUser(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println("Occurred hibernate error");
        } finally {
            session.close();
        }

    }

    @Override
    public void deleteUser(int userId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(session.get(User.class, userId));
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println("Occurred hibernate error");
        } finally {
            session.close();
        }
    }

    @Override
    public void updateUser(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(user);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println("Occurred hibernate error");
        } finally {
            session.close();
        }
    }

    @Override
    public List<User> getAllUser() {
        List<User> users = null;
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            users = (List<User>) session.createQuery("from User").list();
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println("Occurred hibernate error");
        } finally {
            session.close();
        }
        return users;
    }

    @Override
    public User getUserById(int userId) {
        User user = null;
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            user = (User) session.get(User.class, userId);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println("Occurred hibernate error");
        } finally {
            session.close();
        }
        return user;
    }

    @Override
    public int getUserId(String login) {
        int id = -1;
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            String hql = "from User where login = :login";
            System.out.println(login);
            User user = (User) session.createQuery(hql).setParameter("login", login).uniqueResult();
            System.out.println(user);
            if (user != null) {
                id = user.getId();
            }
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println("Occurred hibernate error");
        } finally {
            session.close();
        }
        return id;
    }
}
