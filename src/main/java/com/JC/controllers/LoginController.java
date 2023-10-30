package com.JC.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.JC.business.SecurityServiceInterface;
import com.JC.model.LoginModel;

@Controller
@RequestMapping("/")
public class LoginController {
    
    @Autowired
    SecurityServiceInterface securityService;

    @GetMapping("/")
    public String display(Model model)
    {
        // Display Login Form View
        model.addAttribute("title", "Login Form");
        model.addAttribute("loginModel", new LoginModel());
        return "login";
    }

    @PostMapping("/")
    public String validLogin(@Valid LoginModel loginModel, BindingResult bindingResult, Model model)
    {
        // If check validation errors
        if (bindingResult.hasErrors()) {
            model.addAttribute("title", "Login Form");
            return "login";
        }

        // Check for valid login username and password
        if (securityService.isAuthenticated(loginModel))
        {
            model.addAttribute("model", loginModel);
            return "redirect:/houses/";
        }
        else 
        {
            return "login";
        }
    }
}
