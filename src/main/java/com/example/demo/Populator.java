package com.example.demo;



import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class Populator implements CommandLineRunner {

    @Resource
    UserRepository userRepo;


    @Override
    public void run(String... args) throws Exception {

        User user1 = new User("ChantillyEmail", "Chantilly", "Lace");
        User user2 = new User("nigo@montoya", "Inigo", "Montoya");
        User user3 = new User("mi6", "James", "Bond");

        userRepo.save(user1);
        userRepo.save(user2);
        userRepo.save(user3);


    }
}

