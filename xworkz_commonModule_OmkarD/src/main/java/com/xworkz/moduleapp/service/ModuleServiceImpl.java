package com.xworkz.moduleapp.service;

import com.xworkz.moduleapp.dto.ModuleDto;
import com.xworkz.moduleapp.entity.ModuleEntity;
import com.xworkz.moduleapp.repo.ModuleRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ModuleServiceImpl implements ModuleService {

    private static final int MAX_FAILED_ATTEMPTS = 3;

    @Autowired
    private ModuleRepo moduleRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public boolean signUpValidateAndSave(ModuleDto moduleDto) {
        System.out.println("Validating and saving user: ");

        if (!isValidUser(moduleDto)) {
            System.out.println("Validation failed for user: ");
            return false;
        }

        // Encrypt password before saving
        String encodedPassword = passwordEncoder.encode(moduleDto.getPassword());
        moduleDto.setPassword(encodedPassword);
        moduleDto.setConfirmPassword(encodedPassword);

        // Convert DTO to Entity and save
        ModuleEntity moduleEntity = new ModuleEntity();
        BeanUtils.copyProperties(moduleDto, moduleEntity);
        moduleRepo.signUpSave(moduleEntity);

        System.out.println("User saved successfully: ");
        return true;
    }

    private boolean isValidUser(ModuleDto moduleDto) {
        String fullName = moduleDto.getFullName();
        String phoneNumber = moduleDto.getPhoneNumber();
        String email = moduleDto.getEmail();
        String password = moduleDto.getPassword();
        Integer age = moduleDto.getAge();
        String gender = moduleDto.getGender();
        String location = moduleDto.getLocation();

        // Full Name validation
        if (fullName == null || !fullName.matches("^[A-Z][a-z]+( [A-Z][a-z]*)?$") || fullName.length() < 3 || fullName.length() > 20) {
            return false;
        }

        // Email validation
        if (email == null || !email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$") || isEmailExists(email)) {
            return false;
        }

        // Age validation
        if (age == null || age < 10) {
            return false;
        }

        // Gender and location validation
        if (gender == null || location == null) {
            return false;
        }

        // Phone Number validation
        if (phoneNumber == null || !phoneNumber.matches("^[789]\\d{9}$")) {
            return false;
        }

        // Password validation
        if (password == null || password.length() < 8 || password.length() > 20 ||
                !password.matches(".*[A-Z].*") || !password.matches(".*[a-z].*") ||
                !password.matches(".*\\d.*") || !password.matches(".*[@#$%^&*?=+].*")) {
            return false;
        }

        // Password confirmation
        return moduleDto.getConfirmPassword() != null && password.equals(moduleDto.getConfirmPassword());
    }

    @Override
    public ModuleDto getByEmail(String email) {
        System.out.println("Fetching user details for email: ");
        ModuleEntity moduleEntity = moduleRepo.findByEmail(email);
        if (moduleEntity == null) {
            System.out.println("No user found for email: ");
            return null;
        }

        ModuleDto moduleDto = new ModuleDto();
        BeanUtils.copyProperties(moduleEntity, moduleDto);
        return moduleDto;
    }

    @Override
    public boolean updateUser(ModuleDto userDto) {
        System.out.println("Updating user: ");
        if (userDto == null) return false;

        ModuleEntity userEntity = new ModuleEntity();
        BeanUtils.copyProperties(userDto, userEntity);
        return moduleRepo.updateUser(userEntity);
    }

    @Override
    public void increaseFailedAttempts(String email) {
        System.out.println("Increasing failed login attempts for email: ");
        ModuleEntity moduleEntity = moduleRepo.findByEmail(email);
        if (moduleEntity != null) {
            moduleEntity.setFailedAttempts(moduleEntity.getFailedAttempts() + 1);

            if (moduleEntity.getFailedAttempts() >= MAX_FAILED_ATTEMPTS) {
                lockUserAccount(email);
            } else {
                moduleRepo.updateUser(moduleEntity);
            }
        }
    }

    @Override
    public void lockUserAccount(String email) {
        System.out.println("Locking user account: ");
        ModuleEntity moduleEntity = moduleRepo.findByEmail(email);
        if (moduleEntity != null) {
            moduleEntity.setAccountLocked(true);
            moduleEntity.setLockTime(LocalDateTime.now());
            moduleRepo.updateUser(moduleEntity);
        }
    }

    @Override
    public void resetFailedAttempts(String email) {
        System.out.println("Resetting failed attempts for email:");
        ModuleEntity moduleEntity = moduleRepo.findByEmail(email);
        if (moduleEntity != null) {
            moduleEntity.setFailedAttempts(0);
            moduleEntity.setAccountLocked(false);
            moduleEntity.setLockTime(null);
            moduleRepo.updateUser(moduleEntity);
        }
    }

    @Override
    public String getSignInStatus(String email, String password) {
        System.out.println("Checking sign-in status for email: ");
        ModuleEntity moduleEntity = moduleRepo.findByEmail(email);

        if (moduleEntity == null) {
            System.out.println("User not found: ");
            return "USER_NOT_FOUND";
        }

        if (moduleEntity.isAccountLocked()) {
            LocalDateTime unlockTime = moduleEntity.getLockTime().plusHours(24);
            if (LocalDateTime.now().isAfter(unlockTime)) {
                unlockUserAccount(email);
                System.out.println("Account unlocked automatically: ");
            } else {
                return "LOCKED";
            }
        }

        if (!passwordEncoder.matches(password, moduleEntity.getPassword())) {
            increaseFailedAttempts(email);
            System.out.println("Invalid password attempt for email: ");
            return "INVALID_PASSWORD";
        }

        resetFailedAttempts(email);
        System.out.println("Sign-in successful for email: ");
        return "SUCCESS";
    }

    @Override
    public boolean unlockUserAccount(String email) {
        System.out.println("Manually unlocking user account: ");
        ModuleEntity moduleEntity = moduleRepo.findByEmail(email);
        if (moduleEntity != null && moduleEntity.isAccountLocked()) {
            moduleEntity.setAccountLocked(false);
            moduleEntity.setFailedAttempts(0);
            moduleEntity.setLockTime(null);
            moduleRepo.updateUser(moduleEntity);
            return true;
        }
        return false;
    }

    @Override
    public boolean isEmailExists(String email) {
        return moduleRepo.findByEmail(email) != null;
    }

    @Override
    public LocalDateTime getUnlockTime(String email) {
        ModuleEntity moduleEntity = moduleRepo.findByEmail(email);
        if (moduleEntity != null && moduleEntity.isAccountLocked()) {
            return moduleEntity.getLockTime().plusHours(24);
        }
        return null;
    }

    @Override
    public Long isEmailId(String email) {
        return moduleRepo.isEmailId(email);
    }

    @Override
    public Long isUserName(String fullName) {
        return moduleRepo.isUserName(fullName);
    }

    @Override
    public Long checkPhoneNumber(String phoneNumber) {
        return moduleRepo.checkPhoneNumber(phoneNumber);
    }
}