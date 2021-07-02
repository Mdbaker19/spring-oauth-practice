package com.example.githuboauth.controller;


import com.example.githuboauth.model.User;
import com.example.githuboauth.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class mainController {

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private userService userService;

    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

    @GetMapping("/profile")
    public String profile(HttpSession session){
        User user = null;
        try{
            user = userService.getLoggedInUser();
        } catch (Exception ignored){}
        if(user == null) {
            return "redirect:/";
        }
        session.setAttribute("user", user);
        return "profile";
    }

    @GetMapping("/")
    public String home() {
        return "welcome";
    }

}
