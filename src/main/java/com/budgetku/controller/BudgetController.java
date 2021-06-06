package com.budgetku.controller;

import com.budgetku.model.Budget;
import com.budgetku.model.User;
import com.budgetku.service.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/budget")
public class BudgetController {

    @Autowired
    private BudgetService budgetService;

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping(path = "/create/{email}", produces = {
        "application/json"}, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseBody
    public String createBudget(
        String payload,
        @PathVariable("email") String email) throws Exception {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String userEmail = authentication.getName();
        System.out.println(payload);
        System.out.println(email);
        return "redirect:/feedback/success";
        // return ResponseEntity.ok(budgetService.createBudget(budget, email));
    }

    @GetMapping("/feedback/success")
    public ResponseEntity<String> getSuccess() {
        return new ResponseEntity<String>("Thank you for submitting feedback.", HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping(path = "/list/{email}", produces = {"application/json"})
    @ResponseBody
    public ResponseEntity<Iterable<Budget>> listBudget(@PathVariable(value = "email") String email) {
        return ResponseEntity.ok(budgetService.getListBudgetByUser(email));
    }
}
