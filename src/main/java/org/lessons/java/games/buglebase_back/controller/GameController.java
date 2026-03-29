package org.lessons.java.games.buglebase_back.controller;

import java.util.List;

import org.lessons.java.games.buglebase_back.model.Game;
import org.lessons.java.games.buglebase_back.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/games")
public class GameController {

    @Autowired
    private GameRepository gameRepository;

    @GetMapping
    public String index(Model model) {
        List<Game> result = gameRepository.findAll();
        model.addAttribute("list", result);
        return "/games/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") Integer id, Model model) {
        Game result = gameRepository.findById(id).get();
        model.addAttribute("game", result);
        return "/games/show";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("game", new Game());
        return "/games/create";
    }

    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("game") Game formGame, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "/games/create";
        }

        gameRepository.save(formGame);
        return "redirect:/games";
    }

}
