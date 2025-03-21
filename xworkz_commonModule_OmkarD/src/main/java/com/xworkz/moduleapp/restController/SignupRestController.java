package com.xworkz.moduleapp.restController;

import com.xworkz.moduleapp.service.ModuleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class SignupRestController {

    @Autowired
    private ModuleService moduleService;

    public SignupRestController() {
        System.out.println("SignupRestController initialized");
    }

    @GetMapping("checkEmail")
    public String emailCheck(@RequestParam("email") String email) {
        System.out.println("Checking email: ");
        Long isEmailId = moduleService.isEmailId(email);

        return isEmailId == 0 ? "" : "Email already exists";
    }

    @GetMapping("fullName")
    public String userName(@RequestParam("fullName") String fullName) {
        System.out.println("Checking username: ");
        Long userName = moduleService.isUserName(fullName);

        return userName == 0 ? "" : "Name already exists";
    }

    @GetMapping("checkPhoneNumber")
    public String checkPhoneNo(@RequestParam("phoneNumber") String phoneNumber) {
        System.out.println("Checking phone number: ");
        Long checkPhoneNo = moduleService.checkPhoneNumber(phoneNumber);

        return checkPhoneNo == 0 ? "" : "Phone Number already exists";
    }
}
