package com.example.demo.service;

import com.example.demo.Repository.StadeRepository;
import com.example.demo.model.Stade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class StadeService implements IstadeService{
    @Autowired
    private StadeRepository stadeRepository;
    @Override
    public Stade registreStade(Stade stade){
        stadeRepository.save(stade);
        System.out.println("enrgistrement reussit ");
        return  stade;
    }

    @Override
    public void deleteSade(Long id) {
        Optional<Stade> sadeOptional = stadeRepository.findById(id);

        if (sadeOptional.isPresent()) {
            stadeRepository.deleteById(id);
            System.out.println("Suppression réussie");
        } else {
            System.out.println("L'entité avec l'ID "+id+" n'a pas été trouvée");
        }
    }


    @Override
    public List<Stade> getAll() {
        return null;
    }

    @Override
    public void save(Stade article) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Stade findById(Long id) {
        return null;
    }

    @Override
    public Stade update(Stade stade) {
        Long id = stade.getId();
        Optional<Stade> optionalStade = stadeRepository.findById(id);

        if (optionalStade.isPresent()) {
            Stade existingStade = optionalStade.get();

            // Update the properties of the existingStade with the values from the provided stade
            existingStade.setAddress(stade.getAddress());
            existingStade.setCapacite_stock(stade.getCapacite_stock());
            existingStade.setNom(stade.getNom());
            existingStade.setInformation_contrat(stade.getInformation_contrat());
            existingStade.setPlan_stock(stade.getPlan_stock());

            // Save the updated Stade to the repository
            return stadeRepository.save(existingStade);
        } else {
            // Stade with the given ID does not exist
            System.out.println("Stade with ID " + id + " does not exist");
            return null;
        }
    }

}
