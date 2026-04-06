package org.lessons.java.games.buglebase_back.controller;

import org.lessons.java.games.buglebase_back.model.Studio;
import org.lessons.java.games.buglebase_back.service.StudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/studios")
public class StudioController {

    @Autowired
    private StudioService studioService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("list", studioService.findAllStudios());
        return "/studios/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("studio", studioService.findStudioById(id).get());
        return "/studios/show";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("studio", new Studio());
        return "/studios/createOrEdit";
    }

    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("studio") Studio formStudio, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "/studios/createOrEdit";
        }

        studioService.saveStudio(formStudio);
        return "redirect:/studios";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("studio", studioService.findStudioById(id).get());
        return "/studios/createOrEdit";
    }

    @PostMapping("/edit/{id}")
    public String update(@PathVariable("id") Integer id, @Valid @ModelAttribute() Studio formStudio,
            BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "/studios/edit";
        }

        formStudio.setId(id);
        studioService.saveStudio(formStudio);
        return "redirect:/studios";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id, Model model) {

        studioService.deleteStudioById(id);
        return "redirect:/studios";
    }

}
