package com.buildtrackafrica.buildtrackafrica.dao;

import com.buildtrackafrica.buildtrackafrica.entity.Worker;
import com.buildtrackafrica.buildtrackafrica.util.HibernateUtil;
import jakarta.persistence.EntityManager;
import java.util.List;

public class WorkerDAO {

    public void save(Worker worker) {
        EntityManager em = HibernateUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(worker);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void update(Worker worker) {
        EntityManager em = HibernateUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(worker);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void delete(Long workerId) {
        EntityManager em = HibernateUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            Worker worker = em.find(Worker.class, workerId);
            if (worker != null) em.remove(worker);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public Worker findById(Long workerId) {
        EntityManager em = HibernateUtil.getEntityManager();
        try {
            return em.find(Worker.class, workerId);
        } finally {
            em.close();
        }
    }

    public List<Worker> findAll() {
        EntityManager em = HibernateUtil.getEntityManager();
        try {
            return em.createQuery("SELECT w FROM Worker w", Worker.class)
                    .getResultList();
        } finally {
            em.close();
        }
    }
}