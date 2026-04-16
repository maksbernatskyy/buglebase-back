package org.lessons.java.games.buglebase_back.repository;

import java.util.Optional;

import org.lessons.java.games.buglebase_back.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Integer> {
    Optional<Game> findByName(String name); 
}
