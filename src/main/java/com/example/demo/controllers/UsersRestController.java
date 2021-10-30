package com.example.demo.controllers;


import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/add-user")
    public Collection<User> addUserToDatabase(@RequestBody User userToAdd) throws IOException {

        System.out.println("User: " + userToAdd.getFirstName());
        User newUser = new User(userToAdd.getEmail(), userToAdd.getFirstName(), userToAdd.getLastName());
        userRepo.save(newUser);
        return (Collection<User>) userRepo.findAll();
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


}
