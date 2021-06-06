package com.budgetku.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.budgetku.model.User;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class MainController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/")
    public String home() {
        // return "index";
        return "redirect:/redirect";
    }

    // Trying to get user id instead of email
    @GetMapping("/redirect")
    public ModelAndView redirect(RedirectAttributes redirectAttrs) {
        // String email;
        // Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        // if (principal instanceof User) {
        //     email = ((User)principal).getEmail();
        // } else {
        //     email = principal.toString();
        // }
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();

        ModelAndView mv = new ModelAndView("redirect:http://localhost:8080/redirected");
        redirectAttrs.addFlashAttribute("emailFlash", email);
        mv.addObject("email", email);
        return mv;

        // return new ModelAndView("redirect:http://localhost:8080");
        // return "redirect:http://localhost:8080";
        // ModelAndView mv = new ModelAndView("home");
        // redirectAttrs.addFlashAttribute("email", email);
        // // mv.addObject("email", email);
        // System.out.println(mv);
        // // req.setAttribute("email", email);
        // // return mv;
        // return new ModelAndView("redirect:http://localhost:8080");

        // FlashMap outputFlashMap = RequestContextUtils.getOutputFlashMap(req);
        // if (outputFlashMap != null) {
        //     outputFlashMap.put("email", new User("Awal", "Akhir", email, null, null));
        // }
        // return "redirect:http://localhost:8080/";
    }

    // @RequestMapping("/ans")
    // public String ans(Model model, HttpServletRequest request) {
    //     System.out.println(model);
    //     System.out.println(request);
    //     Map md = model.asMap();
    //     for (Object modelKey : md.keySet()) {
    //         Object modelValue = md.get(modelKey);
    //         System.out.println(modelKey + " -- " + modelValue);
    //     }

    //     System.out.println("=== Request data ===");

    //     java.util.Enumeration<String> reqEnum = request.getParameterNames();
    //     while (reqEnum.hasMoreElements()) {
    //         String s = reqEnum.nextElement();
    //         System.out.println(s);
    //         System.out.println("==" + request.getParameter(s));
    //     }
    //     return "index";
    // }

}
