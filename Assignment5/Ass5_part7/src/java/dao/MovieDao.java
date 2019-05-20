/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import pojo.Movie;

/**
 *
 * @author rahulzore
 */
public class MovieDao {
    private SessionFactory sessionFactory;
    private static Session session;

    protected SessionFactory setUp() {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties())
                .build();
        try {
            sessionFactory = configuration.buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sessionFactory;
    }

    public Session getSession() {
        if (session == null) {
            session = setUp().openSession();
        }
        return session;
    }

    private void beginTransaction() {
        getSession().beginTransaction();
    }

    private void commit() {
        getSession().getTransaction().commit();
    }

    private void close() {
        getSession().close();
    }

    private void rollbackTransaction() {
        getSession().getTransaction().rollback();
    }

    public List<Movie> getMovies(String type, String keyword) {
        List<Movie> movies = new ArrayList<>();
        try {
            beginTransaction();
            Session session = getSession();
            Query q = session.createQuery("from Movie where " + type + "=:keyword");
            System.out.println(q.toString());
            q.setString("keyword", keyword);
            movies = q.list();
            commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            try {
                rollbackTransaction();
            } catch (Exception ex) {
                Logger.getLogger(MovieDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (Exception ex) {
            Logger.getLogger(MovieDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                //close();
            } catch (Exception ex) {
                Logger.getLogger(MovieDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return movies;
    }

    public int addMovie(Movie movie) {
        int result = 0;
        try {
            beginTransaction();
            Session session = getSession();
            session.save(movie);
            commit();
            result = 1;
        } catch (HibernateException e) {
            e.printStackTrace();
            try {
                rollbackTransaction();
            } catch (Exception ex) {
                Logger.getLogger(MovieDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (Exception ex) {
            Logger.getLogger(MovieDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
//                close();
            } catch (Exception ex) {
                Logger.getLogger(MovieDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }
}
