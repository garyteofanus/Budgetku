package com.budgetku.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MainController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/redirect";
    }

    // Trying to get user id instead of email
    @GetMapping("/redirect")
    public ModelAndView redirect(RedirectAttributes redirectAttrs) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();

        ModelAndView mv = new ModelAndView("redirect:http://localhost:8080/redirected");
        redirectAttrs.addFlashAttribute("emailFlash", email);
        mv.addObject("email", email);
        return mv;
    }

}
