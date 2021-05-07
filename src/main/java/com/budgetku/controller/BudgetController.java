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

    @GetMapping("/")
    public String budgetLimiter(Model model) {
        model.addAttribute("budget", new Budget());
        return "budget-limiter.html";
    }

    @PostMapping("/add-budget")
    public String addBudget(@ModelAttribute Budget budget) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();
        budgetService.createBudget(budget);
        return "redirect:/budget-limiter?success";
    }

    @GetMapping("/list-budget")
    public String listBudget(Model model) {
//        List<Budget> dummyBudget = new ArrayList<>();
//        dummyBudget.add(new Budget(100000, LocalDateTime.parse("2021-05-03T00:00:00"), "Budget makanan"));
//        dummyBudget.add(new Budget(30000, LocalDateTime.parse("2021-05-04T00:00:00"), "Budget obat"));
//        dummyBudget.add(new Budget(50000, LocalDateTime.parse("2021-05-05T00:00:00"), "Budget transport"));\
//        model.addAttribute("budgetList", dummyBudget);
        return "list-budget";
    }
}
