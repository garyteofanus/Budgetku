package com.budgetku.controller;

import com.budgetku.model.Kategori;
import com.budgetku.service.KategoriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/kategori")
public class KategoriController {

    @Autowired
    private KategoriService kategoriService;

    @GetMapping(produces = {"application/json"})
    @ResponseBody
    public ResponseEntity<Iterable<Kategori>> getListKategoriByUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();
        return ResponseEntity.ok(kategoriService.getListKategoriByUser(userEmail));
    }

    @PostMapping(produces = {"application/json"})
    @ResponseBody
    public ResponseEntity createKategori(@RequestBody Kategori kategori) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();
        return ResponseEntity.ok(kategoriService.createKategori(kategori, userEmail));
    }
}

