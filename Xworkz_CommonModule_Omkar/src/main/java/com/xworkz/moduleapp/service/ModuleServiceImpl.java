package com.xworkz.moduleapp.service;

import com.xworkz.moduleapp.dto.ModuleDto;
import com.xworkz.moduleapp.entity.ModuleEntity;
import com.xworkz.moduleapp.repo.ModuleRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import sun.nio.cs.ext.DoubleByte;

import static jdk.internal.dynalink.support.NameCodec.encode;

@Service
public class ModuleServiceImpl implements ModuleService {

    @Autowired
    ModuleRepository moduleRepository;


    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public String ValidateAndSave(ModuleDto moduleDto, Model model) {
        String name = moduleDto.getName();
        String phoneNumber = moduleDto.getPhoneNumber();
        String email = moduleDto.getEmail();
        String password = moduleDto.getPassword();
        Integer age = moduleDto.getAge();
        String gender = moduleDto.getGender();
        String location = moduleDto.getLocation();

        // Validation for name
        if (name == null || name.isEmpty()) {
            model.addAttribute("nameError", " Name is required");
            return "signUp.jsp";
        }
        if (!name.matches("^[A-Z].*")) {
            model.addAttribute("nameError", "Name must start with an uppercase letter");
            return "signUp.jsp";
        }
        if (!name.matches("^[A-Z][a-z]+( [A-Z][a-z]*)?$")) {
            model.addAttribute("nameError", "Invalid name format. ");
            return "signUp.jsp";
        }
        if (name.length() < 3 || name.length() > 20) {
            model.addAttribute("nameError", " Name must be between 3 and 20 characters");
            return "signUp.jsp";
        }

        // Validation for email
        if (email == null || email.isEmpty()) {
            model.addAttribute("emailError", "Email is required");
            return "signUp.jsp";
        }
        if (!email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            model.addAttribute("emailError", "Invalid email format (e.g., user@example.com)");
            return "signUp.jsp";
        }
        // Check if email is already registered
        if (isEmailExists(email)) {
            model.addAttribute("emailError", "Email already registered. Please log in.");
            return "signUp.jsp";
        }

        // Validation for age
        if (age == null || age < 10) {
            model.addAttribute("ageError", "Age should be above 10");
            return "signUp.jsp";
        }

        // Validation for gender
        if (gender == null) {
            model.addAttribute("genderError", "Gender is required");
            return "signUp.jsp";
        }

        // Validation for location
        if (location == null) {
            model.addAttribute("locationError", "Location cannot be empty");
            return "signUp.jsp";
        }

        // Validation for phoneNumber
        if (phoneNumber == null || phoneNumber.isEmpty()) {
            model.addAttribute("phoneNumberError", "Phone number is required");
            return "signUp.jsp";
        }
        if (!phoneNumber.matches("^\\d{10}$")) {
            model.addAttribute("phoneNumberError", "Phone number must be exactly 10 digits");
            return "signUp.jsp";
        }
        if (!phoneNumber.matches("^[789]\\d{9}$")) {
            model.addAttribute("phoneNumberError", "Phone number must start with 7, 8, or 9");
            return "signUp.jsp";
        }

        // Validation for password
        if (password == null || password.isEmpty()) {
            model.addAttribute("passwordError", "Password is required");
            return "signUp.jsp";
        }
        if (password.length() < 8 || password.length() > 20) {
            model.addAttribute("passwordError", "Password must be between 8 and 20 characters long");
            return "signUp.jsp";
        }
        if (!password.matches(".*[A-Z].*")) {
            model.addAttribute("passwordError", "Password must contain at least one uppercase letter");
            return "signUp.jsp";
        }
        if (!password.matches(".*[a-z].*")) {
            model.addAttribute("passwordError", "Password must contain at least one lowercase letter");
            return "signUp.jsp";
        }
        if (!password.matches(".*\\d.*")) {
            model.addAttribute("passwordError", "Password must contain at least one number");
            return "signUp.jsp";
        }
        if (!password.matches(".*[@#$%^&*?=+].*")) { // **Fixed special character regex**
            model.addAttribute("passwordError", "Password must contain at least one special character");
            return "signUp.jsp";
        }

        // Validation for password and confirm password
        if (moduleDto.getConfirmPassword() == null || moduleDto.getConfirmPassword().isEmpty()) {
            model.addAttribute("confirmPasswordError", "Confirm password is required");
            return "signUp.jsp";
        }
        if (!moduleDto.getPassword().equals(moduleDto.getConfirmPassword())) {
            model.addAttribute("confirmPasswordError", "Password does not match");
            return "signUp.jsp";
        }
        String encodedPassword=passwordEncoder.encode(moduleDto.getPassword());
        moduleDto.setPassword(encodedPassword);
        moduleDto.setConfirmPassword(encodedPassword);

        // Saving user data
        ModuleEntity moduleEntity = new ModuleEntity();
        BeanUtils.copyProperties(moduleDto, moduleEntity);
        moduleRepository.signUpSave(moduleEntity);

        model.addAttribute("name", name);
        return "signResponse.jsp";
    }

    @Override
    public String getSignIn(String email, String password, Model model) {
        ModuleEntity moduleEntity = moduleRepository.onSignin(email);

        // Check if email exists
        if (moduleEntity == null) {
            model.addAttribute("emailError", "Email does not exist");
            return "signin.jsp";
        }

        if(!passwordEncoder.matches(password,moduleEntity.getPassword())){
            model.addAttribute("error","Invalid password");
            return "signin.jsp";
        }

        // **Check if password is correct**
        if (!moduleEntity.getPassword().equals(password)) {
            model.addAttribute("error", "Invalid password");
            return "signin.jsp";
        }
        if(moduleEntity.getPassword()==null||moduleEntity.getPassword().isEmpty()){
            model.addAttribute("error","password is required");
            return "signin.jsp";
        }

        model.addAttribute("name", moduleEntity.getName());
        return "signInResponse.jsp";
    }
    

    public boolean isEmailExists(String email) {
        return moduleRepository.findByEmail(email) != null;
    }

    @Override
    public ModuleDto findByEmail(String email) {
        ModuleDto moduleDto = new ModuleDto();
        ModuleEntity moduleEntity = moduleRepository.findByEmail(email);

        BeanUtils.copyProperties(moduleEntity, moduleDto);
        System.out.println("GET-SERVICE :" + moduleEntity);
        return moduleDto;
    }

    // update the details by email
    @Override
    public boolean updatebyEmail(ModuleDto moduleDto, Model model) {

        boolean isValidate = true;

        if (moduleDto != null) {

            ModuleEntity entity = new ModuleEntity();
            BeanUtils.copyProperties(moduleDto,entity);

            if (moduleDto.getName() != null && !moduleDto.getName().isEmpty() &&
                    moduleDto.getName().length() >= 3 && moduleDto.getName().length() <= 25 &&
                    moduleDto.getName().matches("[A-Z][a-z]*")) {
                    entity.setName(moduleDto.getName());
            } else {
                isValidate = false;
                model.addAttribute("userNameError", "Username must be between 3 and 25 characters and start with an uppercase letter");
            }

            String strPhone = moduleDto.getPhoneNumber() != null ? moduleDto.getPhoneNumber().toString() : "";
            if (moduleDto.getPhoneNumber() != null && strPhone.length() == 10 && strPhone.matches("^[976]\\d{9}$")) {
                entity.setPhoneNumber(moduleDto.getPhoneNumber());
            } else {
                isValidate = false;
                model.addAttribute("phoneNoError", "Phone number must be exactly 10 digits and start with 9, 7, or 6");
            }

            if (moduleDto.getEmail() != null && moduleDto.getEmail().contains("@gmail.com") && moduleDto.getEmail().matches("^[a-z0-9]+@gmail\\.com$")) {
                entity.setEmail(moduleDto.getEmail());
            } else {
                isValidate = false;
                model.addAttribute("emailError", "Email must be contain @ and gmail.com and use any numbers");
            }

            if (moduleDto.getAge() != null && moduleDto.getAge() >= 18) {
                entity.setAge(moduleDto.getAge());
            } else {
                isValidate = false;
                model.addAttribute("ageError", "Age must be above 18+");
            }

            if (moduleDto.getPassword().equals(moduleDto.getConfirmPassword()) && moduleDto.getPassword().length() >= 8 && moduleDto.getPassword().matches(".*[0-9].*") && moduleDto.getPassword().matches(".*[!@#$%^&,.].*") && moduleDto.getPassword().matches(".*[A-Z].*")) {
                DoubleByte.Encoder encodedPassword;
                String encoded = encode(moduleDto.getPassword());
                entity.setPassword(encoded);

            } else {
                isValidate = false;
                model.addAttribute("passwordError", "Password must be at least 8 characters and must be contain Special character and Numbers");
            }

            if (isValidate) {
                return moduleRepository.updateByEmail(entity);
            }
        }
        return false;
    }

}
