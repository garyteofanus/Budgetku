package com.budgetku.controller;

import com.budgetku.model.Budget;
import com.budgetku.model.Kategori;
import com.budgetku.service.KategoriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/kategori")
public class KategoriController {

    @Autowired
    private KategoriService kategoriService;

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping(path = "/{email}", produces = {"application/json"})
    @ResponseBody
    public ResponseEntity<Iterable<Kategori>> listKategori(@PathVariable(value = "email") String email) {
        return ResponseEntity.ok(kategoriService.getListKategoriByUser(email));
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping(path = "/create/{email}", produces = {"application/json"},consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity createKategori(@PathVariable(value = "email") String email, @RequestBody Kategori kategori) {
        return ResponseEntity.ok(kategoriService.createKategori(kategori, email));
    }
}

