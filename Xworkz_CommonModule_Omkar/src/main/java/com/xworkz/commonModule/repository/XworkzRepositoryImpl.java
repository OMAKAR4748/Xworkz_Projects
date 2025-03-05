package com.xworkz.commonModule.repository;

import com.xworkz.commonModule.entity.XworkzEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Repository
public class XworkzRepositoryImpl implements XworkzRepository {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ecommerce");

    @Override
    public boolean save(XworkzEntity entity) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
            System.out.println("Entity saved successfully");
            return true;
        } catch (Exception e) {
            System.err.println("Error saving entity: " + e.getMessage());
            return false;
        } finally {
            em.close();
        }
    }
}
