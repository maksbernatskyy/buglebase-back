package org.lessons.java.games.buglebase_back.controller;

import java.util.List;

import org.lessons.java.games.buglebase_back.model.Game;
import org.lessons.java.games.buglebase_back.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

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

}
