package com.budgetku.controller;

import com.budgetku.model.Budget;
import com.budgetku.model.Kategori;
import com.budgetku.model.User;
import com.budgetku.service.BudgetService;
import com.budgetku.service.KategoriService;
import com.budgetku.service.UserService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/budget")
public class BudgetController {

    @Autowired
    private BudgetService budgetService;

    @Autowired
    private KategoriService kategoriService;

    @Autowired
    private UserService userService;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/create/{email}",
        produces = {"application/json"},
        consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Budget> createBudget(
        @RequestBody Map<String, String> payload,
        @PathVariable("email") String email) {

        Long nominal = Long.valueOf(payload.get("nominal"));
        String bulanBerakhir = payload.get("bulanBerakhir");
        String tahunBerakhir = payload.get("tahunBerakhir");
        String deskripsi = payload.get("deskripsi");
        Kategori kategori =
            kategoriService.getKategoriFromId(Long.valueOf(payload.get("kategori")));
        User user = userService.getUserFromEmail(email);

        Budget budget =
            new Budget(nominal, bulanBerakhir, tahunBerakhir, deskripsi, kategori, user);
        return ResponseEntity.ok(budgetService.createBudget(budget, email));
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/list/{email}", produces = {"application/json"})
    @ResponseBody
    public ResponseEntity<Iterable<Budget>> listBudget(@PathVariable(value = "email") String email) {
        return ResponseEntity.ok(budgetService.getListBudgetByUser(email));
    }
}
