package com.xworkz.moduleapp.repo;

import com.xworkz.moduleapp.entity.ModuleEntity;

public interface ModuleRepository {

    boolean signUpSave(ModuleEntity moduleEntity);

    ModuleEntity onSignin(String email);

    ModuleEntity findByEmail(String email);

    boolean updateByEmail(ModuleEntity moduleEntity);

}
