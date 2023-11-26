package com.example.demo.service;

import com.example.demo.Repository.BilletRepository;
import com.example.demo.model.Billet;
import com.example.demo.model.Match;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class BilletService implements IBilletService {
    @Autowired
    BilletRepository billetRepository;
    @Override
    public List<Billet> getAll() {
        return billetRepository.findAll();
    }

    @Override
    public Billet save(Billet article) {
        return billetRepository.save(article);
    }

    @Override
    public void deleteById(Long id) {
        billetRepository.deleteById(id);
    }

    @Override
    public Optional<Billet> findById(Long id) {
        return billetRepository.findById(id);
    }

    @Override
    public Billet update(Billet stade) {
           /*   @ManyToOne
   private Match match;
     private Statut_reservation statut_reservation;
     @ManyToMany
     private List<Client> Acheteur;*/

        Long id = stade.getId();
        Optional<Billet> optionalStade = billetRepository.findById(id);

        if (optionalStade.isPresent()) {
            Billet existingStade = optionalStade.get();

            // Update the properties of the existingStade with the values from the provided stade
            existingStade.setAcheteur(stade.getAcheteur());
            existingStade.setMatch(stade.getMatch());
            existingStade.setStatut_reservation(stade.getStatut_reservation());
            // Save the updated Stade to the repository
            return billetRepository.save(existingStade);
        } else {
            // Stade with the given ID does not exist
            System.out.println("Match with ID " + id + " does not exist");
            return null;
        }
    }


}
