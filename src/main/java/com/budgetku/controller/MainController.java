package com.budgetku.controller;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MainController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/frontend")
    public String frontend() {
        return "redirect:/redirect";
    }

    @GetMapping("/redirect")
    public String redirect(RedirectAttributes redirectAttributes) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        redirectAttributes.addAttribute("email", email);
        return "redirect:http://localhost:8080";
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

}
