package com.budgetku.controller;

import java.util.ArrayList;
import java.util.List;

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
        List<String[]> dummyBudget = new ArrayList<>();
        dummyBudget.add(new String[]{"Makanan", "50.000", "Budget makanan bulanan"});
        dummyBudget.add(new String[]{"Pulsa", "50.000", "Budget pulsa bulanan"});
        dummyBudget.add(new String[]{"Belanja", "50.000", "Budget belanja online bulanan"});
        dummyBudget.add(new String[]{"Obat", "50.000", "Budget obat bulanan"});
        dummyBudget.add(new String[]{"Transport", "50.000", "Budget transport bulanan"});
        model.addAttribute("budgetList", dummyBudget);
        return "list-budget";
    }
}
