package com.xworkz.moduleapp.restController;


import com.xworkz.moduleapp.entity.ModuleEntity;
import com.xworkz.moduleapp.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class SignupRestController {

    SignupRestController(){
        System.out.println("===============================");
    }

    @Autowired
    ModuleService moduleService;

    @GetMapping("checkEmail")
    public String emailCheck(@RequestParam("email") String email){
//        System.out.println("emailCheck ");
        Long isemailId=moduleService.isEmailId(email);

        if(isemailId==0){
            return "";
        }else {
            return "Email exist";
        }

    }

    @GetMapping("fullName")
    public String userName(@RequestParam("fullName") String fullName){
//        System.out.println("userName ");
        ModuleEntity userName = moduleService.isUserName(fullName);

        if(userName == null){
            return "";
        }else {
            return "userName exist";
        }

    }

    @GetMapping("checkAge")
    public String CheckAge(@RequestParam("age") Integer age){
//        System.out.println("CheckAge ");
        ModuleEntity checkAge = moduleService.checkAge(age);

        if(checkAge == null){
            return "";
        }else {
            return "Age exist";
        }

    }

    @GetMapping("checkPhoneNumber")
    public String CheckPhoneNo(@RequestParam("age") String phoneNumber){
//        System.out.println("CheckPhoneNo");
        ModuleEntity checkPhoneNo = moduleService.checkPhoneNo(phoneNumber);

        if(checkPhoneNo == null){
            return "";
        }else {
            return "Phone Number exist";
        }

    }

}
