package com.example.demo.controllers;


import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@Controller
public class BasicsController {

    @Resource
    UserRepository userRepo;

    @RequestMapping("/")
    public String displayRoot() {
        return "welcome";
    }

    @RequestMapping("/welcome")
    public String displayWelcomePage() {
        return "welcome";
    }

    @RequestMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "signup_form";
    }

    @RequestMapping("/register_success")
    public String showSuccessfulRegistrationForm() {
        return "register_success";
    }

//    @PostMapping("/process_register")
//    public String processRegister(@ModelAttribute("user") User user) {
//        System.out.println("Log process_register step: " + user.getFirstName());
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        String encodedPassword = passwordEncoder.encode(user.getPassword());
//        user.setPassword(encodedPassword);
//
//        System.out.println(user.getFirstName() + "  " + user.getEmail() + "    " + user.getPassword());
//
//        userRepo.save(user);
//        return "redirect:register_success";
//    }

    @PostMapping("/process_register")
    public String processRegister(@ModelAttribute User incomingUser) {

        User userToAdd = new User(incomingUser.getEmail());
        userToAdd.setFirstName(incomingUser.getFirstName());

        System.out.println("incoming email is: " + userToAdd.getEmail());
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(incomingUser.getPassword());
        userToAdd.setPassword(encodedPassword);

//        System.out.println(userToAdd.getFirstName() + "  " + userToAdd.getEmail() + "    " + incomingUser.getPassword());

        userRepo.save(userToAdd);
        System.out.println("we have a saved user at   " +   userRepo.findByEmail(userToAdd.getEmail()).getFirstName());
        return "redirect:register_success";
    }

    @RequestMapping("/about-us")
    public String displayAboutUsPage() {

        return "aboutUs";
    }

    @GetMapping("/login")
    public String displayLoginPage() {

        return "login";
    }


}
