package com.budgetku.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/budget-limiter")
    public String budgetLimiter(Model model) {
        model.addAttribute("budget");
        return "budgetLimiter/index.html";
    }

    @PostMapping("/budget-limiter/add-budget")
    public String addBudget(Model model) {
        return "redirect:/budget-limiter?success";
    }
}
