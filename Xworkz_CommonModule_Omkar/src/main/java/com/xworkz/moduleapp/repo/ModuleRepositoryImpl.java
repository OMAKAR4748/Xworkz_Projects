package com.xworkz.moduleapp.repo;

import com.xworkz.moduleapp.entity.ModuleEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.*;

@Repository
public class ModuleRepositoryImpl implements ModuleRepository {

    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ecommerce");


    @Override
    public boolean signUpSave(ModuleEntity moduleEntity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            if (moduleEntity != null) {
                entityManager.getTransaction().begin();
                entityManager.persist(moduleEntity);
                entityManager.getTransaction().commit();
                return true;
            }
            return false;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
        return false;
    }



    @Override
    public ModuleEntity findByEmail(String email) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try{
           Query query= entityManager.createNamedQuery("getByEmail",ModuleEntity.class);
            System.out.println("email"+ModuleEntity.class);
           query.setParameter("email",email);
           ModuleEntity moduleEntity=(ModuleEntity) query.getSingleResult();
           return moduleEntity;

        }catch (Exception e){
            System.out.println("error: "+e.getMessage());
            return null;
        }

    }
}
