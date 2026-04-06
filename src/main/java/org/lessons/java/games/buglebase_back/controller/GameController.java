package org.lessons.java.games.buglebase_back.controller;

import java.util.List;

import org.lessons.java.games.buglebase_back.model.Game;
import org.lessons.java.games.buglebase_back.model.Studio;
import org.lessons.java.games.buglebase_back.service.GameService;
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
    private GameService gameService;

    @GetMapping
    public String index(Model model) {
        List<Game> result = gameService.findAllGames();
        model.addAttribute("list", result);
        return "/games/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") Integer id, Model model) {
        Game result = gameService.findGameById(id).get();
        model.addAttribute("game", result);
        Studio studio = result.getStudio();
        model.addAttribute("studio", studio);
        return "/games/show";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("game", new Game());
        model.addAttribute("studios", gameService.findAllStudios());
        return "/games/createOrEdit";
    }

    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("game") Game formGame, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("studios", gameService.findAllStudios());
            return "/games/createOrEdit";
        }

        gameService.saveGame(formGame);
        return "redirect:/games";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("game", gameService.findGameById(id).get());
        model.addAttribute("studios", gameService.findAllStudios());
        return "/games/createOrEdit";
    }

    @PostMapping("/edit/{id}")
    public String update(@PathVariable("id") Integer id, @Valid @ModelAttribute("game") Game formGame,
            BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("studios", gameService.findAllStudios());
            return "/games/createOrEdit";
        }

        formGame.setId(id);
        gameService.saveGame(formGame);
        return "redirect:/games";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        gameService.deleteGameById(id);
        return "redirect:/games";
    }
}
