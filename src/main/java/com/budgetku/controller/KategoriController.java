package com.budgetku.controller;

import com.budgetku.model.Kategori;
import com.budgetku.service.KategoriService;
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

@RestController
@RequestMapping("/kategori")
public class KategoriController {

    @Autowired
    private KategoriService kategoriService;

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/{email}", produces = {"application/json"})
    @ResponseBody
    public ResponseEntity<Iterable<Kategori>> listKategori(
        @PathVariable(value = "email") String email) {
        return ResponseEntity.ok(kategoriService.getListKategoriByUser(email));
    }


    @CrossOrigin(origins = "*")
    @PostMapping(path = "/create/{email}",
        produces = {"application/json"},
        consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Kategori> createKategori(@PathVariable(value = "email") String email,
                                                   @RequestBody Kategori kategori) {
        return ResponseEntity.ok(kategoriService.createKategori(kategori, email));
    }
}

