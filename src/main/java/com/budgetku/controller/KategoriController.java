package com.budgetku.controller;

import com.budgetku.service.KategoriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/kategori")
public class KategoriController {

    @Autowired
    private KategoriService kategoriService;

    @GetMapping
    public String getKategori(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();
        model.addAttribute("kategori", kategoriService.getListKategoriByUser(userEmail));
        return "kategori";
    }

    @PostMapping("/add-kategori")
    public String addKategori(
        @RequestParam(value = "nama") String namaKategori,
        @RequestParam(value = "deskripsi") String deskripsi
    ) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();
        kategoriService.createKategori(namaKategori, deskripsi, userEmail);
        return "redirect:/kategori?success";
    }
}

