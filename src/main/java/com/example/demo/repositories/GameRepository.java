package com.example.demo.repositories;

import com.example.demo.models.Game;
import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends CrudRepository<Game, Long> {

    Game findByTitle(String gameTitle);
}
