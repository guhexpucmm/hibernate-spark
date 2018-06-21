package com.guhex.service;

import com.guhex.hibernate.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class ServiceGeneric <T> {

    private String entity;
    private Session session;

    public ServiceGeneric(Class<T> t) {
        entity = t.getClass().getName();
        session = HibernateUtil.buildSessionFactory().openSession();
    }

    public void insert(T t) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateUtil.openSession();
            transaction = session.beginTransaction();

            session.save(t);

            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
        } finally {
            closeAll();
        }
    }

    public void update(T t) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateUtil.openSession();
            transaction = session.beginTransaction();

            session.update(t);

            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
        } finally {
            closeAll();
        }
    }

    public void delete(T t) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateUtil.openSession();
            transaction = session.beginTransaction();

            session.delete(t);

            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
        } finally {
            closeAll();
        }
    }

    public List<T> findAll() {
        Session session = null;
        Transaction transaction = null;
        Query query = null;

        try {
            session = HibernateUtil.openSession();
            transaction = session.beginTransaction();

            query = session.createQuery("from " + entity);

            return ((org.hibernate.query.Query) query).list();
        } catch (HibernateException e) {
            transaction.rollback();

            return null;
        } finally {
            closeAll();
        }
    }

    private void closeAll() {
        session.close();
    }
}
