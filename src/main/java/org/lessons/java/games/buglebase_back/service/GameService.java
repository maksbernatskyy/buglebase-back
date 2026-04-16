package org.lessons.java.games.buglebase_back.service;

import java.util.List;
import java.util.Optional;

import org.lessons.java.games.buglebase_back.model.Game;
import org.lessons.java.games.buglebase_back.model.Studio;
import org.lessons.java.games.buglebase_back.repository.GameRepository;
import org.lessons.java.games.buglebase_back.repository.StudioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private StudioRepository studioRepository;

    public List<Game> findAllGames() {
        return gameRepository.findAll();
    }

    public Optional<Game> findGameById(Integer id) {
        return gameRepository.findById(id);
    }

    public Optional<Game> findGameByName(String name) {
        return gameRepository.findByName(name);
    }

    public List<Studio> findAllStudios() {
        return studioRepository.findAll();
    }

    public Optional<Studio> findStudioById(Integer id) {
        return studioRepository.findById(id);
    }

    public Game saveGame(Game game) {
        if (game.getStudio() != null && game.getStudio().getId() != null) {
            Studio studio = studioRepository.findById(game.getStudio().getId()).orElse(null);
            game.setStudio(studio);
        }
        return gameRepository.save(game);
    }

    public void deleteGameById(Integer id) {
        gameRepository.deleteById(id);
    }
}
