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

    @Override
    public int updateByEmail(String email, ModuleEntity dto) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createNamedQuery("updateByEmail");
        query.setParameter("email", email);
        query.setParameter("name", dto.getName());
        query.setParameter("age", dto.getAge());
        query.setParameter("gender", dto.getGender());
        query.setParameter("location", dto.getLocation());
        query.setParameter("phoneNumber", dto.getPhoneNumber());
        query.setParameter("password", dto.getPassword());
        query.setParameter("confirmPassword", dto.getConfirmPassword());

        return query.executeUpdate();
    }
}
