package com.example.demo.service;

import com.example.demo.Repository.MatchRepository;
import com.example.demo.model.Client;
import com.example.demo.model.Match;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class MatchService implements IMatchService{
    @Autowired
    MatchRepository matchRepository;
    @Override
    public List<Match> getAll() {
        return matchRepository.findAll();
    }

    @Override
    public Match save(Match article) {
        return matchRepository.save(article);
    }

    @Override
    public void deleteById(Long id) {
matchRepository.deleteById(id);
    }

    @Override
    public Optional<Match> findById(Long id) {
        return matchRepository.findById(id);
    }

    @Override
    public Match update(Match stade) {

        Long id = stade.getId();
        Optional<Match> optionalStade = matchRepository.findById(id);

        if (optionalStade.isPresent()) {
            Match existingStade = optionalStade.get();

            // Update the properties of the existingStade with the values from the provided stade
            existingStade.setStade(stade.getStade());
            existingStade.setDate(stade.getDate());
            existingStade.setEquipe(stade.getEquipe());
            existingStade.setPrix_billets(stade.getPrix_billets());
            existingStade.setNbrbillet(stade.getNbrbillet());
            // Save the updated Stade to the repository
            return matchRepository.save(existingStade);
        } else {
            // Stade with the given ID does not exist
            System.out.println("Match with ID " + id + " does not exist");
            return null;
        }
    }
}
