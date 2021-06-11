package com.budgetku.controller;

import com.budgetku.dto.UserRegistrationDto;
import com.budgetku.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class UserRegisController {

    private final UserService userService;

    public UserRegisController(UserService userService) {
        this.userService = userService;
    }

    @CrossOrigin(origins = "*")
    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }

    @CrossOrigin(origins = "*")
    @GetMapping
    public String showRegistrationForm(Model model) {
        model.addAttribute("user");
        return "registration";
    }

    @CrossOrigin(origins = "*")
    @PostMapping
    public String registerUser(@ModelAttribute("user") UserRegistrationDto registrationDto) {
        userService.save(registrationDto);
        return "redirect:/register?success";
    }
}
