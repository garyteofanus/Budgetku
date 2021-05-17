package com.budgetku.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

    @GetMapping("/list-budget")
    public String listBudget(Model model) {
//        List<Budget> dummyBudget = new ArrayList<>();
//        dummyBudget.add(new Budget(100000, LocalDateTime.parse("2021-05-03T00:00:00"), "Budget makanan"));
//        dummyBudget.add(new Budget(30000, LocalDateTime.parse("2021-05-04T00:00:00"), "Budget obat"));
//        dummyBudget.add(new Budget(50000, LocalDateTime.parse("2021-05-05T00:00:00"), "Budget transport"));
//
//        model.addAttribute("budgetList", dummyBudget);
        return "list-budget";
    }
}
