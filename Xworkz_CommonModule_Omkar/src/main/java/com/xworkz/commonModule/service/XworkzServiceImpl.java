package com.xworkz.commonModule.service;

import com.xworkz.commonModule.dto.XworkzDto;
import com.xworkz.commonModule.entity.XworkzEntity;
import com.xworkz.commonModule.repository.XworkzRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class XworkzServiceImpl implements XworkzService {

    @Autowired
    private XworkzRepository xworkzRepository;

    @Override
    public boolean validateAndSave(XworkzDto dto, Model model) {
        if (dto.getName() == null || dto.getName().trim().isEmpty()) {
            model.addAttribute("error", "Name cannot be empty");
            return false;
        }

        if (dto.getEmail() == null || !dto.getEmail().matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            model.addAttribute("error", "Invalid email format");
            return false;
        }

        if (dto.getPhoneNumber() == null || !dto.getPhoneNumber().equals("^[0-9]{10}$")) {
            model.addAttribute("error", "Invalid phone number format. It must be 10 digits.");
            return false;
        }

        if (dto.getPassword() == null || dto.getPassword().length() < 6) {
            model.addAttribute("error", "Password must be at least 6 characters long");
            return false;
        }

        if (!dto.getPassword().equals(dto.getConfirmPassword())) {
            model.addAttribute("error", "Passwords do not match");
            return false;
        }

        // Map DTO to Entity
        XworkzEntity entity = new XworkzEntity();
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setPhoneNumber(Long.parseLong(String.valueOf(dto.getPhoneNumber())));
        entity.setPassword(dto.getPassword());
        entity.setConfirmPassword(dto.getConfirmPassword());
        entity.setGender(dto.getGender());
        entity.setLocation(dto.getLocation());
        entity.setDob(dto.getDob());
        entity.setBloodGroup(dto.getBloodGroup());

        boolean isSaved = xworkzRepository.save(entity);
        if (!isSaved) {
            model.addAttribute("error", "Failed to save data. Please try again.");
            return false;
        }

        System.out.println("DTO is valid and saved: " + dto);
        return true;
    }
}
