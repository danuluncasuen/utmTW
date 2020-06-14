package com.utm.tw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    @GetMapping("/")
    public ModelAndView landing() {
        return new ModelAndView("main.html");
    }

    @GetMapping("/register")
    public ModelAndView register() {
        return new ModelAndView("registration.html");
    }

    @GetMapping("/chat")
    public ModelAndView chat() {
        return new ModelAndView("chatpage.html");
    }

}
