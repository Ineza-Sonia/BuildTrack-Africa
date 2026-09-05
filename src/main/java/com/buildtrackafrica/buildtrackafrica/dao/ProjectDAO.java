package com.buildtrackafrica.buildtrackafrica.dao;

import com.buildtrackafrica.buildtrackafrica.entity.Project;
import com.buildtrackafrica.buildtrackafrica.util.HibernateUtil;
import jakarta.persistence.EntityManager;
import java.util.List;

public class ProjectDAO {

    public void save(Project project) {
        EntityManager em = HibernateUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(project);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void update(Project project) {
        EntityManager em = HibernateUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(project);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void delete(Long projectId) {
        EntityManager em = HibernateUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            Project project = em.find(Project.class, projectId);
            if (project != null) em.remove(project);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public Project findById(Long projectId) {
        EntityManager em = HibernateUtil.getEntityManager();
        try {
            return em.find(Project.class, projectId);
        } finally {
            em.close();
        }
    }

    public List<Project> findAll() {
        EntityManager em = HibernateUtil.getEntityManager();
        try {
            return em.createQuery("SELECT p FROM Project p", Project.class)
                    .getResultList();
        } finally {
            em.close();
        }
    }
}