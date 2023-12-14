package com.example.pfa.Service;

import com.example.pfa.Model.FicheDeRecherche;
import com.example.pfa.Model.Personne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PersonneService implements IPersonne{
    @Autowired
    private com.example.pfa.Dao.IPersonne iPersonne;
    @Override
    public List<Personne> getAll() {
        return iPersonne.findAll();
    }

    @Override
    public Personne save(Personne article) {
        return iPersonne.save(article);
    }

    @Override
    public void deleteById(Long id) {
        iPersonne.deleteById(id);

    }

    @Override
    public Optional<Personne> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Personne update(Personne stade) {
        Long id = stade.getId();
        Optional<Personne> optionalStade = iPersonne.findById(id);

        if (optionalStade.isPresent()) {
            Personne existingStade = optionalStade.get();
            existingStade.setCIN(stade.getCIN());

            return iPersonne.save(existingStade);
        } else {
            // Stade with the given ID does not exist
            System.out.println("Personne with ID " + id + " does not exist");
            return null;
        }    }

}
