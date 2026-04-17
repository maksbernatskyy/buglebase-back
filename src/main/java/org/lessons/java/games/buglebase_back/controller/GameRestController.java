package org.lessons.java.games.buglebase_back.controller;

import java.util.List;
import java.util.Optional;

import org.lessons.java.games.buglebase_back.model.Game;
import org.lessons.java.games.buglebase_back.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@CrossOrigin
@RequestMapping("/api/games")
public class GameRestController {

    @Autowired
    private GameService gameService;

    @GetMapping
    public ResponseEntity<List<Game>> index() {
        List<Game> list = gameService.findAllGames();
        if (list.isEmpty()) {
            return new ResponseEntity<List<Game>>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<List<Game>>(list, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Game> show(@PathVariable("id") Integer id) {
        Optional<Game> game = gameService.findGameById(id);

        if (game.isPresent()) {
            return new ResponseEntity<Game>(game.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<Game>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Game> create(@RequestBody Game formGame) {
        Game game = gameService.saveGame(formGame);

        return new ResponseEntity<Game>(game, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Game> edit(@PathVariable("id") Integer id, @RequestBody Game formGame) {
        Game game = gameService.saveGame(formGame);
        game.setId(id);
        return new ResponseEntity<Game>(game, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        gameService.deleteGameById(id);
    }
}
