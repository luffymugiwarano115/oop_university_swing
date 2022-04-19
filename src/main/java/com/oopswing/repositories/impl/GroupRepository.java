package com.oopswing.repositories.impl;

import com.oopswing.models.entities.Group;
import com.oopswing.repositories.Repository;
import com.oopswing.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class GroupRepository implements Repository<Group> {
    private Session currentSession;

    private Transaction currentTransaction;

    public GroupRepository(){

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

    public void persist(Group entity) {
        getCurrentSession().save(entity);
    }

    public void update(Group entity) {
        getCurrentSession().update(entity);
    }

    public Group findById(int id) {
        return getCurrentSession().get(Group.class, id);
    }

    public void delete(Group entity) {
        getCurrentSession().delete(entity);
    }

    public List<Group> findAll() {
        return (List<Group>) getCurrentSession().createQuery("from Group").list();
    }

    public void deleteAll() {
        List<Group> entityList = findAll();
        for (Group entity : entityList) {
            delete(entity);
        }
    }
}
