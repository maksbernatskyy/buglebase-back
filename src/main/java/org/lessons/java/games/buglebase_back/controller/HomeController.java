package org.lessons.java.games.buglebase_back.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequestMapping("/")
public class HomeController {
    @GetMapping
    public String home(Model model) {
        return "/home/home";
    }
    
}
