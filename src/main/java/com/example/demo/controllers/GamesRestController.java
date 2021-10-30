package com.example.demo.controllers;


import com.example.demo.models.Game;
import com.example.demo.models.User;
import com.example.demo.repositories.GameRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Collection;


//For reference:
// https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html

@Controller
public class GamesRestController {

    @Resource
    GameRepository gameRepo;

    //INDEX
//    @RequestMapping(value="/games")
//    public Collection<Game> getAllGames(Model model) {
//        return (Collection<Game>) gameRepo.findAll();
//    }

    @RequestMapping(value="/games")
    public ModelAndView getAllGames(Model model) {
        Collection<Game> games = (Collection<Game>)gameRepo.findAll();
        ModelAndView mv = new ModelAndView("games/games-index");//setting view name here
        mv.addObject("games", games);
        return mv;
    }

    //    @RequestMapping("/fetch-all-games")
    //    public Collection<Game> getAllGamesList() {
    //        return (Collection<Game>) gameRepo.findAll();
    //    }

    //SHOW (id)
    @RequestMapping(value="/games/{id}")
    public Collection<Game> getGameById(@PathVariable String id) {
        return (Collection<Game>) gameRepo.findById(id);
    }

    //SHOW (title)
//    @RequestMapping(value="/games/{title}")
//    public Collection<Game> getGameByTitle(@PathVariable String title) {
//        return (Collection<Game>) gameRepo.findByTitleIn(title);
//    }

    //NEW (form)
    @RequestMapping("/games/new")
    public String showNewGameForm(Model model) {
        model.addAttribute("game", new Game());
        return "games/games-new";
    }

    //NEW (submit)
    @PostMapping("/games")
    public String addGame(@ModelAttribute Game gameToAdd) throws IOException {
        Game newGame = new Game(
                gameToAdd.getGameTitle(),
                gameToAdd.getTargetGradeRange(),
                gameToAdd.getGameDescription()
        );

        gameRepo.save(newGame);
        return "/games/games-index"; //(Collection<Game>) gameRepo.findAll();

    }

    //EDIT (form)
    @RequestMapping("/games/{id}/edit")
    public String showEditGameForm(Model model) {
        model.addAttribute("game", new Game());
        return "games/games-edit";
    }

    //EDIT (submit)
    @PostMapping("/games/{id}")
    public String editGame(@ModelAttribute Game gameToEdit) throws IOException {
        Game newGame = new Game(
                gameToEdit.getGameTitle(),
                gameToEdit.getTargetGradeRange(),
                gameToEdit.getGameDescription()
        );

        gameRepo.save(newGame);
        return "/games/games-index"; // (Collection<Game>) gameRepo.findAll();

    }

    //DELETE
    @PostMapping("/game")
    public String deleteGame(@ModelAttribute Game gameToDelete) throws IOException {

        if (gameRepo.existsById(gameToDelete.getId())) {
            gameRepo.deleteById(gameToDelete.getId());
        }
        return "/games/games-index"; // (Collection<Game>) gameRepo.findAll();
    }

}
