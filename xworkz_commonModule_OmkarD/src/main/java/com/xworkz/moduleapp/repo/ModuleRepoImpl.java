package com.xworkz.moduleapp.repo;

import com.xworkz.moduleapp.entity.ModuleEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.*;
import java.time.LocalDateTime;

@Repository
public class ModuleRepoImpl implements ModuleRepo {


    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Override
    public boolean signUpSave(ModuleEntity moduleEntity) {
        System.out.println("Saving user: {}"+ moduleEntity.getEmail());
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(moduleEntity);
            entityManager.getTransaction().commit();
            System.out.println("User saved successfully: {}"+ moduleEntity.getEmail());
            return true;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println("Error saving user: {}"+ e.getMessage());
            return false;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public ModuleEntity findByEmail(String email) {
        System.out.println("Fetching user by email: {}"+ email);
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            Query query = entityManager.createNamedQuery("getByEmail");
            query.setParameter("email", email);
            ModuleEntity moduleEntity = (ModuleEntity) query.getSingleResult();

            if (moduleEntity.isAccountLocked() && moduleEntity.getLockTime() != null) {
                LocalDateTime unlockTime = moduleEntity.getLockTime().plusHours(24);
                if (LocalDateTime.now().isAfter(unlockTime)) {
                    System.out.println("Unlocking user account: {}"+ email);
                    unlockUserAccount(email);
                    moduleEntity.setAccountLocked(false);
                    moduleEntity.setFailedAttempts(0);
                    moduleEntity.setLockTime(null);
                }
            }
            return moduleEntity;
        } catch (NoResultException e) {
            System.out.println("No user found with email: {}"+ email);
            return null;
        } catch (Exception e) {
            System.out.println("Error fetching user: {}"+ e.getMessage());
            return null;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public boolean updateUser(ModuleEntity moduleEntity) {
        System.out.println("Updating user: {}"+ moduleEntity.getEmail());
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(moduleEntity);
            entityManager.getTransaction().commit();
            System.out.println("User updated successfully: {}"+ moduleEntity.getEmail());
            return true;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println("Error updating user: {}"+ e.getMessage());
            return false;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void unlockUserAccount(String email) {
        System.out.println("Unlocking account for email: {}"+ email);
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery("UPDATE ModuleEntity m SET m.accountLocked = false, m.failedAttempts = 0, m.lockTime = NULL WHERE m.email = :email");
            query.setParameter("email", email);
            query.executeUpdate();
            entityManager.getTransaction().commit();
            System.out.println("Account unlocked successfully for email: {}"+email);
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println("Error unlocking account: {}"+ e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    @Override
    public Long isEmailId(String email) {
        System.out.println("Checking if email exists: {}"+ email);
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            Query query = entityManager.createNamedQuery("checkEmail");
            query.setParameter("email", email);
            return (Long) query.getSingleResult();
        } catch (Exception e) {
            System.out.println("Error checking email: {}"+ e.getMessage());
            return 0L;
        }
    }

    @Override
    public Long isUserName(String fullName) {
        System.out.println("Checking if username exists: {}"+ fullName);
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            Query query = entityManager.createNamedQuery("name");
            query.setParameter("fullName", fullName);
            return (Long) query.getSingleResult();
        } catch (Exception e) {
            System.out.println("Error checking username: {}"+ e.getMessage());
            return 0L;
        }
    }

    @Override
    public Long checkPhoneNumber(String phoneNumber) {
        System.out.println("Checking if phone number exists: {}"+phoneNumber);
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try{
            Query query = entityManager.createNamedQuery("checkPhoneNo");
            query.setParameter("phoneNumber", phoneNumber);
            return (Long) query.getSingleResult();
        } catch (Exception e) {
            System.out.println("Error checking phone number: "+e.getMessage());
            return 0L;
        }
    }
}
