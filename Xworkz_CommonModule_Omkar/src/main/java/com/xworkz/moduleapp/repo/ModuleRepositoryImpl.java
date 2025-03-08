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
    public ModuleEntity onSignin(String email) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try{
           Query query= entityManager.createNamedQuery("getEmailAndPass");
           query.setParameter("email",email);
           ModuleEntity moduleEntity=(ModuleEntity) query.getSingleResult();
           return moduleEntity;

        }catch (Exception e){
            System.out.println("error: "+e.getMessage());
            return null;
        }
    }

    @Override
    public ModuleEntity findByEmail(String email) {
        EntityManager eManag = entityManagerFactory.createEntityManager();
        Query query = eManag.createNamedQuery("findByEmail").setParameter("email", email);
        query.getSingleResult();
        System.out.println("REPOSITORY :" + query.getSingleResult());
        return (ModuleEntity) query.getSingleResult();
    }

    @Override
    public boolean updateByEmail(ModuleEntity moduleEntity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Query query = entityManager.createNamedQuery("updateByEmail");

            query.setParameter("name", moduleEntity.getName());
            query.setParameter("email", moduleEntity.getEmail());
            query.setParameter("age", moduleEntity.getAge());
            query.setParameter("gender", moduleEntity.getGender());
            query.setParameter("phoneNumber", moduleEntity.getPhoneNumber());
            query.setParameter("location", moduleEntity.getLocation());
            query.setParameter("password", moduleEntity.getPassword());
            query.setParameter("confirmPassword", moduleEntity.getConfirmPassword());

            int updatedCount = query.executeUpdate();
            transaction.commit();
            return updatedCount > 0;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction.isActive()) {
                transaction.rollback();
            }
            return false;
        } finally {
            entityManager.close();
        }
    }

}
