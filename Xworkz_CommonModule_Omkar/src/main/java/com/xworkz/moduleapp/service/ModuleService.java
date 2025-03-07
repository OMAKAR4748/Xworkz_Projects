package com.xworkz.moduleapp.service;

import com.xworkz.moduleapp.dto.ModuleDto;
import com.xworkz.moduleapp.entity.ModuleEntity;
import org.springframework.ui.Model;

public interface ModuleService {

    String ValidateAndSave(ModuleDto moduleDto, Model model);

    String getSignIn(String email, String password, Model model);

    boolean updateDetailsByEmail(String email, ModuleDto dto, Model model);

    }
