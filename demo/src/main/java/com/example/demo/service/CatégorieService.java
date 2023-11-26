package com.example.demo.service;

import com.example.demo.Repository.CatégorieRepository;
import com.example.demo.Repository.ClientRepository;
import com.example.demo.model.Catégorie;
import com.example.demo.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CatégorieService implements ICatégrieService{
    @Autowired
    private CatégorieRepository catégorieRepository;
    @Override
    public List<Catégorie> getAll() {
        return catégorieRepository.findAll();

    }

    @Override
    public Catégorie save(Catégorie article) {
        return    catégorieRepository.save(article);
    }

    @Override
    public void deleteById(Long id) {
        catégorieRepository.deleteById(id);
    }

    @Override
    public Optional<Catégorie> findById(Long id) {
        return catégorieRepository.findById(id);
    }

    @Override
    public Catégorie update(Catégorie stade) {
        Long id = stade.getId();
        Optional<Catégorie> optionalStade = catégorieRepository.findById(id);

        if (optionalStade.isPresent()) {
            Catégorie existingStade = optionalStade.get();

            // Update the properties of the existingStade with the values from the provided stade
            existingStade.setDescription(stade.getDescription());
            existingStade.setPrix(stade.getPrix());
            existingStade.setNom(stade.getNom());
            // Save the updated Stade to the repository
            return catégorieRepository.save(existingStade);
        } else {
            // Stade with the given ID does not exist
            System.out.println("Catégorie with ID " + id + " does not exist");
            return null;
        }
    }
}
