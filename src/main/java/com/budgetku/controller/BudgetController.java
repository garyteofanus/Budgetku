package com.budgetku.controller;

import com.budgetku.model.Budget;
import com.budgetku.service.BudgetService;
import com.budgetku.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/budget")
public class BudgetController {

    @Autowired
    private BudgetService budgetService;

    @Autowired
    private UserService userService;

    @GetMapping("")
    public String budgetLimiter(Model model) {
        model.addAttribute("budget", new Budget());

        String[] categories = {"Category 1", "Category 2"};
        model.addAttribute("categories", categories);
        return "budget-limiter.html";
    }

    @PostMapping("/add-budget")
    public String addBudget(@ModelAttribute Budget budget) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();
        budgetService.createBudget(budget, userEmail);
        return "redirect:/budget";
    }
}
