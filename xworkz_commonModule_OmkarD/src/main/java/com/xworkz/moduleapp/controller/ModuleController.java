package com.xworkz.moduleapp.controller;

import com.xworkz.moduleapp.dto.ModuleDto;
import com.xworkz.moduleapp.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("/")
public class ModuleController {


    @Autowired
    private ModuleService moduleService;

    public ModuleController() {
        System.out.println("ModuleController object is created");
    }

    @PostMapping("/userSignUp")
    public String userSignUp(@ModelAttribute("moduleDto") ModuleDto moduleDto, Model model) {
        System.out.println("Received sign-up request for user: ");
        boolean isSaved = moduleService.signUpValidateAndSave(moduleDto);

        if (!isSaved) {
            System.out.println("Sign-up failed for user: ");
            model.addAttribute("inValid", "Invalid input fields. Please check again.");
            return "signUp";
        } else {
            System.out.println("Sign-up successful for user: ");
            model.addAttribute("name", moduleDto.getFullName());
            return "signResponse";
        }
    }


    @GetMapping("/userSignIn")
    public String userSignIn(@RequestParam("email") String email,
                             @RequestParam("password") String password,
                             Model model) {
        System.out.println("Sign-in attempt for email: ");
        String loginStatus = moduleService.getSignInStatus(email, password);

        switch (loginStatus) {
            case "LOCKED":
                System.out.println("Account locked for email: ");
                LocalDateTime unlockTime = moduleService.getUnlockTime(email);
                if (unlockTime != null) {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                    model.addAttribute("unlockTime", unlockTime.format(formatter));
                    model.addAttribute("msg", "Your account is locked. Try again after.");
                }
                return "signin";

            case "USER_NOT_FOUND":
            case "INVALID_PASSWORD":
                System.out.println("Invalid login attempt for email: ");
                model.addAttribute("inValidData", "Invalid email or password");
                return "signin";

            case "SUCCESS":
                System.out.println("Sign-in successful for email: ");
                model.addAttribute("validData", email);
                return "signInResponse";

            default:
                System.out.println("Unexpected login error for email: ");
                model.addAttribute("msg", "Unexpected error. Please try again.");
                return "signin";
        }
    }


    @GetMapping("/fetchUsers")
    public String fetchByEmail(@RequestParam("email") String email, Model model) {
        System.out.println("Fetching user details for email: ");
        ModuleDto moduleDto = moduleService.getByEmail(email);

        if (moduleDto == null) {
            System.out.println("No user found for email: ");
            model.addAttribute("msg", "User not found");
            return "errorPage";
        }

        System.out.println("User details retrieved successfully for email: ");
        model.addAttribute("user", moduleDto);
        return "updatePage";
    }


    @PostMapping("/updateUser")
    public String updateUser(@ModelAttribute("moduleDto") ModuleDto moduleDto, Model model) {
        System.out.println("Update request received for user: ");
        boolean isUpdated = moduleService.updateUser(moduleDto);

        if (isUpdated) {
            System.out.println("User profile updated successfully for: ");
            model.addAttribute("emailId", moduleDto.getEmail());
            model.addAttribute("msg", "Profile Updated Successfully");
            return "updateSuccess";
        } else {
            System.out.println("Failed to update user profile for: ");
            model.addAttribute("msg", "Data not updated!");
            return "updatePage";
        }
    }


    @PostMapping("/unlockAccount")
    public String unlockAccount(@RequestParam("email") String email, Model model) {
        System.out.println("Unlock account request received for email: ");
        boolean isUnlocked = moduleService.unlockUserAccount(email);

        if (isUnlocked) {
            System.out.println("Account unlocked successfully for email: ");
            model.addAttribute("msg", "Your account has been unlocked. You can now log in.");
            return "signin";
        } else {
            System.out.println("Failed to unlock account for email: ");
            model.addAttribute("msg", "Unable to unlock account. Contact support.");
            return "accountLocked";
        }
    }


    @GetMapping("/signUpPage")
    public String signUpPage(){
        return "signUp";
    }

    @ResponseBody
    @RequestMapping("/photo/{profileImage}")
    public byte[] testPhoto(@PathVariable String profileImage) {
        Path imagePath = Paths.get("\"D:\\GSS\\angadi\"", profileImage);

        try {
            if (Files.exists(imagePath)) {
                return Files.readAllBytes(imagePath);
            } else {
                System.out.println("Image not found: ");
                return new byte[0];
            }
        } catch (IOException e) {
            System.out.println("Error reading image file: ");
            return new byte[0];
        }
    }
}
