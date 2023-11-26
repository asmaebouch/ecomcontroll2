package com.example.demo.service;

import com.example.demo.Repository.ClientRepository;
import com.example.demo.Repository.EquipeRepository;
import com.example.demo.model.Client;
import com.example.demo.model.Equipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EquipeService implements IEquipeService{
    @Autowired
    private EquipeRepository equipeRepository;
    @Override
    public List<Equipe> getAll() {
        return equipeRepository.findAll();
    }

    @Override
    public Equipe save(Equipe article) {
        return equipeRepository.save(article);
    }

    @Override
    public void deleteById(Long id) {
        equipeRepository.deleteById(id);
    }

    @Override
    public Optional<Equipe> findById(Long id) {
        return equipeRepository.findById(id);
    }

    @Override
    public Equipe update(Equipe stade) {
        Long id = stade.getId();
        Optional<Equipe> optionalStade = equipeRepository.findById(id);
        if (optionalStade.isPresent()) {
            Equipe existingStade = optionalStade.get();

            // Update the properties of the existingStade with the values from the provided stade
            existingStade.setLogo(stade.getLogo());
            existingStade.setVille_equipe(stade.getVille_equipe());
            existingStade.setNom(stade.getNom());
            // Save the updated Stade to the repository
            return equipeRepository.save(existingStade);
        } else {
            // Stade with the given ID does not exist
            System.out.println("Equipe with ID " + id + " does not exist");
            return null;
        }
    }
}
