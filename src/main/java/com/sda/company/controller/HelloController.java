package com.sda.company.controller;

import com.sda.company.models.LoginForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {


    @RequestMapping("/hello")
    public String indexPage() {
        return "start";
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute(name = "loginForm") LoginForm loginForm) {
        String username = loginForm.getUsername();
        String password = loginForm.getPassword();

        if (username.equalsIgnoreCase("ADMIN") && password.equalsIgnoreCase("1234")) {
            return "home";
        }
        return "start";
    }
}
