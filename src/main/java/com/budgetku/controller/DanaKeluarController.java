package com.budgetku.controller;

import com.budgetku.model.User;
import com.budgetku.service.DanaKeluarService;
import com.budgetku.service.UserService;
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
@RequestMapping("/danakeluar")
public class DanaKeluarController {

    @Autowired
    private DanaKeluarService danaKeluarService;

    @Autowired
    private UserService userService;

    @GetMapping
    public String showDanaKeluarForm(){
        return "danakeluar";
    }

    @PostMapping
    public String makeNewDanaKeluar(
        @RequestParam(value = "nominal") Integer nominal,
        @RequestParam(value = "tanggal") String tanggal,
        @RequestParam(value = "deskripsi") String deskripsi
    ) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();
        danaKeluarService.createDanaKeluar(nominal, tanggal, deskripsi, userEmail);
        return "redirect:/danakeluar?success";
    }
}