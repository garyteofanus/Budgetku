package com.budgetku.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.budgetku.service.KategoriService;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class KategoriController {

    @Autowired
    private KategoriService kategoriService;

    @GetMapping("/kategori")
    public String kategori(){
        return "kategori";
    }

    @PostMapping("/kategori")
    public String createKategori(HttpServletRequest request){
        String namaKategori= request.getParameter("nama");
        String deskripsi = request.getParameter("deskripsi");
        String userEmail = getLoggedinUserName();
        kategoriService.createKategori(namaKategori, deskripsi,userEmail);
        return "redirect:/kategori";
    }

    private String getLoggedinUserName() {
        Object principal = SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            return ((UserDetails) principal).getUsername();
        }
        return principal.toString();
    }
}

