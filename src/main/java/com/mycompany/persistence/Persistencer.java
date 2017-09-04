/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.persistence;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

/**
 *
 * @author Carlos Urango
 * @param <T>
 * @param <PK>
 */
public class Persistencer<T, PK> {

    private static final Logger LOG = Logger.getLogger(Persistencer.class.getName());
    protected Class<T> entityClass;
    protected EntityManager entityManager;
    
    
    public Persistencer(){
        this.entityManager = JPAConnection.CONNECTION.getEntityManager();
    }

    public T add(T entity) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(entity);
            entityManager.getTransaction().commit();
        } catch (RuntimeException e) {
            LOG.log(Level.WARNING, e.getMessage());
        }
        return entity;

    }

    public T update(T entity) {
        try {
            entityManager.merge(entity);
        } catch (Exception e) {
            LOG.log(Level.WARNING, e.getMessage());
        }
        return entity;
    }

    public T find(PK id) {
        T entity;
        try {
            entity = entityManager.find(entityClass, id);
        } catch (NoResultException | NonUniqueResultException e) {
            entity = null;
            LOG.log(Level.WARNING, e.getMessage());
        }
        return entity;
    }

    public T findByName(String name) {
        T entity;
        Query query = entityManager.createQuery("Select e FROM " + entityClass.getSimpleName() + " e WHERE e.name = :name");
        query.setParameter("name", name);
        try {
            entity = (T) query.getSingleResult();
        } catch (NoResultException | NonUniqueResultException e) {
            entity = null;
            LOG.log(Level.WARNING, e.getMessage());
        }
        return entity;
    }

    public T findByEmail(String email) {
        T entity;
        Query query = entityManager.createQuery("Select e FROM " + entityClass.getSimpleName() + " e WHERE e.email = :email");
        query.setParameter("email", email);
        try {
            entity = (T) query.getSingleResult();
        } catch (NoResultException | NonUniqueResultException e) {
            entity = null;
            LOG.log(Level.WARNING, e.getMessage());
        }
        return entity;
    }

    public List<T> all() {
        List<T> entities;
        String queryString = "Select c FROM " + entityClass.getSimpleName() + " c";
        Query query = entityManager.createQuery(queryString);
        try {
            entities = query.getResultList();
        } catch (NoResultException | NonUniqueResultException e) {
            entities = null;
            LOG.log(Level.WARNING, e.getMessage());
        }
        return entities;
    }

    public Boolean delete(T entity) {
        try {
            entity = this.entityManager.merge(entity);
            this.entityManager.remove(entity);
            return true;
        } catch (RuntimeException e) {
            LOG.log(Level.WARNING, e.getMessage());
            return false;
        }
    }
    
}
