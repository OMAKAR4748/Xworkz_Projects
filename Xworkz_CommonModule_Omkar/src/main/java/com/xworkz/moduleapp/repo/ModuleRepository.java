package com.xworkz.moduleapp.repo;

import com.xworkz.moduleapp.entity.ModuleEntity;

public interface ModuleRepository {

    boolean signUpSave(ModuleEntity moduleEntity);

    ModuleEntity findByEmail(String email);

    int updateByEmail(String email, ModuleEntity dto);


}
