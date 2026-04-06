package org.lessons.java.games.buglebase_back.service;

import java.util.List;
import java.util.Optional;

import org.lessons.java.games.buglebase_back.model.Studio;
import org.lessons.java.games.buglebase_back.repository.StudioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudioService {
    @Autowired
    private StudioRepository studioRepository;

    public List<Studio> findAllStudios() {
        return studioRepository.findAll();
    }

    public Optional<Studio> findStudioById(Integer id) {
        return studioRepository.findById(id);
    }

    public Studio saveStudio(Studio studio) {
        return studioRepository.save(studio);
    }

    public void deleteStudioById(Integer id) {
        studioRepository.deleteById(id);
    }
}
