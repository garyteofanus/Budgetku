package com.budgetku.controller;

import com.budgetku.model.Budget;
import com.budgetku.model.User;
import com.budgetku.model.Kategori;
import com.budgetku.service.BudgetService;
import com.budgetku.service.KategoriService;
import com.budgetku.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    @Autowired
    private UserService userService;

    @Autowired
    private KategoriService kategoriService;

    @GetMapping("")
    public String budgetLimiter(Model model) {
        model.addAttribute("budget", new Budget());

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();

        Iterable<Kategori> categories = kategoriService.getListKategoriByUser(userEmail);
        model.addAttribute("categories", categories);
        return "budget-limiter.html";
    }

    @PostMapping("/add-budget")
    public String addBudget(@ModelAttribute Budget budget) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();
        return ResponseEntity.ok(budgetService.createBudget(budget, userEmail));
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping(path = "/list/{email}", produces = {"application/json"})
    @ResponseBody
    public ResponseEntity<Iterable<Budget>> listBudget(@PathVariable(value = "email") String email) {
        return ResponseEntity.ok(budgetService.getListBudgetByUser(email));
    }
}
