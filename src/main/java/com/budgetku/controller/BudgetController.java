package com.budgetku.controller;

import com.budgetku.model.Budget;
import com.budgetku.service.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/budget")
public class BudgetController {

    @Autowired
    private BudgetService budgetService;

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping(path = "/create", produces = {"application/json"})
    @ResponseBody
    public ResponseEntity createBudget(@RequestBody Budget budget) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();
        return ResponseEntity.ok(budgetService.createBudget(budget, userEmail));
    }

    @GetMapping(path = "/list/{userId}", produces = {"application/json"})
    @ResponseBody
    public String listBudget(Model model) {
        model.addAttribute("budgetList", budgetService.getListBudget());
        return "list-budget";
    }
}
