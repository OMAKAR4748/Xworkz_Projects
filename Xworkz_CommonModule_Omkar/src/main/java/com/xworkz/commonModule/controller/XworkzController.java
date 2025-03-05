package com.xworkz.commonModule.controller;

import com.xworkz.commonModule.dto.XworkzDto;
import com.xworkz.commonModule.service.XworkzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class XworkzController {

    @Autowired
    private XworkzService service;

    public XworkzController() {
        System.out.println("XworkzController object is created");
    }

    @GetMapping("/signup")
    public String signup() {
        System.out.println("Displaying SignUp page");
        return "signup";
    }

    @GetMapping("/index")
    public String index() {
        System.out.println("Displaying Home page");
        return "index";
    }

    @PostMapping("/signup")
    public String getSignUp(XworkzDto xworkzDto, Model model) {
        System.out.println("Processing SignUp request");

        boolean isValid = service.validateAndSave(xworkzDto, model);

        if (isValid) {
            System.out.println("SignUp successful, redirecting to response page");
            return "response";
        }

        System.out.println("Validation failed, returning to SignUp page");
        model.addAttribute("dto", xworkzDto);
        return "signup";
    }
}
