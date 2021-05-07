package com.budgetku.controller;

import com.budgetku.model.Budget;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
        model.addAttribute("budget", new Budget());
        return "budgetLimiter/index.html";
    }

    @PostMapping("/budget-limiter/add-budget")
    public String addBudget(@ModelAttribute Budget budget) {
        return "redirect:/budget-limiter?success";
    }
}
