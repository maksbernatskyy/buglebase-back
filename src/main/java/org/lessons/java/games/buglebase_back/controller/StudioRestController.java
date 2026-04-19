package org.lessons.java.games.buglebase_back.controller;

import java.util.List;

import org.lessons.java.games.buglebase_back.model.Studio;
import org.lessons.java.games.buglebase_back.service.StudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@CrossOrigin
@RequestMapping("/api/studios")
public class StudioRestController {

    @Autowired
    private StudioService studioService;

    @GetMapping
    public ResponseEntity<List<Studio>> index() {
        List<Studio> list = studioService.findAllStudios();
        if (list.isEmpty()) {
            return new ResponseEntity<List<Studio>>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<List<Studio>>(list, HttpStatus.OK);
        }
    }

}
