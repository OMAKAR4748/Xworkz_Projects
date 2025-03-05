package com.xworkz.commonModule.service;


import com.xworkz.commonModule.dto.XworkzDto;
import org.springframework.ui.Model;

public interface XworkzService {

    boolean validateAndSave(XworkzDto dto, Model model);

}
