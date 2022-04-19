package com.oopswing.repositories.impl;

import com.oopswing.models.entities.University;
import com.oopswing.repositories.Repository;
import com.oopswing.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UniversityRepository implements Repository<University> {
    private Session currentSession;

    private Transaction currentTransaction;

    public UniversityRepository(){

    }

    public Session openCurrentSession() {
        currentSession = HibernateUtil.getSessionFactory().openSession();
        return currentSession;
    }

    public Session openCurrentSessionwithTransaction() {
        currentSession = HibernateUtil.getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }

    public void closeCurrentSession() {
        currentSession.close();
    }

    public void closeCurrentSessionwithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }

    public Session getCurrentSession() {
        return currentSession;
    }

    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }

    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }

    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }

    public void persist(University entity) {
        getCurrentSession().save(entity);
    }

    public void update(University entity) {
        getCurrentSession().update(entity);
    }

    public University findById(int id) {
        return getCurrentSession().get(University.class, id);
    }

    public void delete(University entity) {
        getCurrentSession().delete(entity);
    }

    public List<University> findAll() {
        return (List<University>) getCurrentSession().createQuery("from University").list();
    }

    public void deleteAll() {
        List<University> entityList = findAll();
        for (University entity : entityList) {
            delete(entity);
        }
    }
}
