package com.sda.company.controller;

import com.sda.company.models.LoginForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Slf4j
@Controller
public class HelloController {


    @RequestMapping("/hello")
    public String indexPage() {
        log.info("Start method called");
        return "start";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute(name = "loginForm") LoginForm loginForm) {
        String userName = loginForm.getUserName();
        String password = loginForm.getPassword();
        log.info("Login method called");
        if (userName.equalsIgnoreCase("ADMIN") && password.equalsIgnoreCase("1234")) {
            return "home";
        }
        return "start";
    }
}
