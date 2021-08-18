package com.example.demo.controllers;


import com.example.demo.models.Game;
import com.example.demo.repositories.GameRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Collection;

@RestController
public class GamesRestController {

    @Resource
    GameRepository gameRepo;


    @RequestMapping("/fetch-all-games")
    public Collection<Game> getAllGamesList() {
        return (Collection<Game>) gameRepo.findAll();
    }

    @PostMapping("/add-game")
    public Collection<Game> addGameToDatabase(@RequestBody Game gameToAdd) throws IOException {

        System.out.println("Game: " + gameToAdd.getTitle());
        Game newGame = new Game(gameToAdd.getTitle(), gameToAdd.getGameLink());

        gameRepo.save(newGame);
        return (Collection<Game>) gameRepo.findAll();

    }

    @PostMapping("/delete-game")
    public Collection<Game> deleteGameFromDatabase(@RequestBody Game gameToDelete) throws IOException {

        if (gameRepo.existsById(gameToDelete.getId())) {
            gameRepo.deleteById(gameToDelete.getId());
        }
        return (Collection<Game>) gameRepo.findAll();
    }

}
