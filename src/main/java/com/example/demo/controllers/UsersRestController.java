package com.example.demo.controllers;


import com.example.demo.models.CustomUserDetails;
import com.example.demo.models.Game;
import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Collection;

@Controller
public class UsersRestController {

    @Resource
    UserRepository userRepo;

//    @RequestMapping("/fetch-all-users")
//    public Collection<User> getAllUsersList() {
//        return (Collection<User>) userRepo.findAll();
//    }

    //INDEX (all, admin only)
    @RequestMapping(value="/stem-careers/admin")
    public ModelAndView getAllCareers(Model model) {
        Collection<User> professionals = (Collection<User>)userRepo.findByRole("Professional");
        ModelAndView mv = new ModelAndView("careers/careers-admin");//setting view name here
        mv.addObject("careers", professionals);
        return mv;
    }

    //INDEX (filter approvedByAdmin, return by keyword)
    @RequestMapping(value="/stem-careers/list")
    public ModelAndView getAllApprovedCareers(Model model) {
        Collection<User> professionals = (Collection<User>)userRepo.findByApprovedByAdminTrue();
        ModelAndView mv = new ModelAndView("careers/careers-index");//setting view name here
        mv.addObject("careers", professionals);
        return mv;
    }

    //INDEX (filter approvedByAdmin, return by keyword)
    @RequestMapping(value="/stem-careers/tags/{tag}")
    public ModelAndView getAllApprovedCareersByKeyword(Model model) {
        Collection<User> professionals = (Collection<User>)userRepo.findByApprovedByAdminTrue();
        ModelAndView mv = new ModelAndView("careers/careers-keyword");//setting view name hereadmin
        mv.addObject("careers", professionals);
        return mv;
    }

    @PostMapping("/add-user")
    public Collection<User> addUserToDatabase(@RequestBody User userToAdd) throws IOException {

        System.out.println("User: " + userToAdd.getFirstName());
        User newUser = new User(userToAdd.getEmail(), userToAdd.getFirstName(), userToAdd.getLastName());
        userRepo.save(newUser);
        return (Collection<User>) userRepo.findAll();
    }

    //SHOW (id)
    @RequestMapping(value="/stem-careers/{id}")
    public ModelAndView getUserById(@PathVariable String id) {
        String role = getLoggedInUserRole();

        User user = (User)userRepo.findById(id);
        ModelAndView mv = new ModelAndView("careers/careers-show");
        mv.addObject("user ", user);
        mv.addObject("role", role);
        return mv;
    }

    //EDIT (form)
    @RequestMapping("/stem-careers/{id}/edit")
    public ModelAndView showEditGameForm(@PathVariable String id) {
        String role = getLoggedInUserRole();

        User user = (User)userRepo.findById(id);
        ModelAndView mv = new ModelAndView("careers/careers-edit");
        mv.addObject("user", user);
        mv.addObject("role", role);
        return mv;
    }

    //EDIT (form)
    @RequestMapping("/stem-careers/{id}/approve")
    public String approveCareer(@PathVariable String id) {
        String role = getLoggedInUserRole();

        User user = (User)userRepo.findById(id);
        user.setApprovedByAdmin(true);
        userRepo.save(user);
        return "careers/careers-admin";
    }

    //EDIT (form)
    @RequestMapping("/stem-careers/{id}/disable")
    public String disableCareer(@PathVariable String id) {
        String role = getLoggedInUserRole();

        User user = (User)userRepo.findById(id);
        user.setApprovedByAdmin(false);
        return "careers/careers-admin";
    }

    @PostMapping("/edit-user")
    public Collection<User> editUserToDatabase(@RequestBody User userToEdit) throws IOException {

        System.out.println("User: " + userToEdit.getFirstName());
        User newUser = new User(userToEdit.getEmail(), userToEdit.getFirstName(), userToEdit.getLastName());
        userRepo.save(newUser);
        return (Collection<User>) userRepo.findAll();
    }

    @PostMapping("/delete-user")
    public Collection<User> deleteUserFromDatabase(@RequestBody User userToDelete) throws IOException {

        if (userRepo.existsById(userToDelete.getId())) {
            userRepo.deleteById(userToDelete.getId());
        }
        return (Collection<User>) userRepo.findAll();
    }

    public String getLoggedInUserRole() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String role = "";
        if (principal instanceof CustomUserDetails) {
            role = ((CustomUserDetails)principal).getRole();
        } else {
            role = principal.toString();
        }

        return role;
    }


}
