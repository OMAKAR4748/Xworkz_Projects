package com.xworkz.moduleapp.service;

import com.xworkz.moduleapp.dto.ModuleDto;


import java.time.LocalDateTime;

public interface ModuleService {

    boolean signUpValidateAndSave(ModuleDto moduleDto);

    ModuleDto getByEmail(String email);

    boolean updateUser(ModuleDto userDto);

    void increaseFailedAttempts(String email);

    void lockUserAccount(String email);

    void resetFailedAttempts(String email);

    String getSignInStatus(String email, String password);

    boolean unlockUserAccount(String email);

    boolean isEmailExists(String email);

    LocalDateTime getUnlockTime(String email);

    Long isEmailId(String email);

    Long  isUserName(String fullName);

    Long checkPhoneNumber(String phoneNumber);




}
