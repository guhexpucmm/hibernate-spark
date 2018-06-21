package com.guhex.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.spi.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HibernateUtil {
    public static SessionFactory sessionFactory = buildSessionFactory();
    public static Session session = null;

    public static SessionFactory buildSessionFactory() {
        SessionFactory sessionFactory = null;
        try {
            Configuration configuration = new Configuration();
            configuration.configure("/public/hibernate.cfg.xml");
            sessionFactory = configuration.buildSessionFactory();
        } catch (ServiceException e) {

        }
        return sessionFactory;
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static Session getSession() {
        return session;
    }

    public static Session openSession() {
        return getSessionFactory().openSession();
    }

    public static void closeSession() {
        session.close();
    }
}