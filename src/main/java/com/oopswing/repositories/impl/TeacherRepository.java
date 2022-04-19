package com.oopswing.repositories.impl;

import com.oopswing.models.entities.Teacher;
import com.oopswing.repositories.Repository;
import com.oopswing.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class TeacherRepository implements Repository<Teacher> {
    private Session currentSession;

    private Transaction currentTransaction;

    public TeacherRepository(){

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

    public void persist(Teacher entity) {
        getCurrentSession().save(entity);
    }

    public void update(Teacher entity) {
        getCurrentSession().update(entity);
    }

    public Teacher findById(int id) {
        return getCurrentSession().get(Teacher.class, id);
    }

    public void delete(Teacher entity) {
        getCurrentSession().delete(entity);
    }

    public List<Teacher> findAll() {
        return (List<Teacher>) getCurrentSession().createQuery("from Teacher").list();
    }

    public void deleteAll() {
        List<Teacher> entityList = findAll();
        for (Teacher entity : entityList) {
            delete(entity);
        }
    }
}
