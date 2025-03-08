package com.xworkz.moduleapp.controller;

import com.xworkz.moduleapp.dto.ModuleDto;
import com.xworkz.moduleapp.enums.Location;
import com.xworkz.moduleapp.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/")
public class ModuleController {

    @Autowired
    private ModuleService moduleService;

    public ModuleController() {
        System.out.println("ModuleController object is created");
    }

    @PostMapping("/userSignUp")
    public String userSignUp(@Valid @ModelAttribute("moduleDto") ModuleDto moduleDto, Model model) {
        System.out.println("user sign up is running..");
        model.addAttribute("name",moduleDto);
        moduleService.ValidateAndSave(moduleDto, model);
        return "signResponse.jsp";
    }

    @PostMapping("/userSignIn")
    public String userSignIn(@RequestParam("email") String email, @RequestParam("password") String password, Model model) {
        System.out.println("user sign in is running..");
         moduleService.getSignIn(email, password, model);
         return "signInResponse.jsp";
    }



    @GetMapping("/onUpdate")
    public String update(@RequestParam String email, Model model) {
        System.out.println("Email Controller:" + email);
        System.out.println("Update page display with email");
        model.addAttribute("email", email);
        return "Update.jsp";
    }

    @GetMapping("/updateDetails")
    public String updateDetails(@RequestParam String email, Model model) {
        ModuleDto moduleDto = moduleService.findByEmail(email);
        List<Location> location = new ArrayList<>(Arrays.asList(Location.values()));
        System.out.println(location);
        model.addAttribute("list", location);
        model.addAttribute("dto", moduleDto);
        System.out.println("Update Details page Display");
        return "UpdateDetailsResponse.jsp";
    }

    @PostMapping("/updateDetails")
    public String updateDetails(ModuleDto moduleDto, Model model){
        moduleService.updatebyEmail(moduleDto, model);
        model.addAttribute("email", moduleDto.getEmail());
        return "UpdateSuccess.jsp";
    }

}
