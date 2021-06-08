package com.budgetku.controller;

import com.budgetku.model.DanaKeluar;
import com.budgetku.service.DanaKeluarService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/danakeluar")
public class DanaKeluarController {

    private final DanaKeluarService danaKeluarService;

    public DanaKeluarController(DanaKeluarService danaKeluarService) {
        this.danaKeluarService = danaKeluarService;
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping(path = "/create/{email}", produces = {"application/json"} ,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity makeNewDanaKeluar(@PathVariable(value = "email") String email, @RequestBody DanaKeluar danaKeluar) {
        return ResponseEntity.ok(danaKeluarService.createDanaKeluar(danaKeluar, email));
    }
}
