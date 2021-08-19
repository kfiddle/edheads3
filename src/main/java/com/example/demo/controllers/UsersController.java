package com.example.demo.controllers;


import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class UsersController {

    @Resource
    UserRepository userRepo;

    @RequestMapping("/all-users")
    public String displayAllUsersInDatabase(Model model) {
        model.addAttribute("allUsersList", userRepo.findAll());
        return "allUsers";
    }


}
