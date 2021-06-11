package com.budgetku.controller;

import com.budgetku.model.Budget;
import com.budgetku.model.DanaKeluar;
import com.budgetku.model.User;
import com.budgetku.service.BudgetService;
import com.budgetku.service.DanaKeluarService;
import com.budgetku.service.UserService;
import java.util.Map;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/danakeluar")
public class DanaKeluarController {

    private final DanaKeluarService danaKeluarService;

    private final BudgetService budgetService;

    private final UserService userService;

    public DanaKeluarController(DanaKeluarService danaKeluarService,
                                BudgetService budgetService,
                                UserService userService) {
        this.danaKeluarService = danaKeluarService;
        this.budgetService = budgetService;
        this.userService = userService;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/create/{email}",
        produces = {"application/json"},
        consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<DanaKeluar> makeNewDanaKeluar(@PathVariable(value = "email") String email,
                                                        @RequestBody Map<String, String> payload) {

        Integer nominal = Integer.valueOf(payload.get("nominal"));
        Budget budget = budgetService.getBudgetById(Long.valueOf(payload.get("budget")));
        String deskripsi = payload.get("deskripsi");
        User user = userService.getUserFromEmail(email);

        DanaKeluar danaKeluar = new DanaKeluar(nominal, budget, deskripsi, user);

        return ResponseEntity.ok(danaKeluarService.createDanaKeluar(danaKeluar, email));
    }
}
