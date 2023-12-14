package com.example.pfa.Service;

import com.example.pfa.Dao.IPoliceT;
import com.example.pfa.Model.Personne;
import com.example.pfa.Model.PoliceT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PoliceTService implements IPoliceTService{
    @Autowired
    IPoliceT iPoliceT;
    @Override
    public List<PoliceT> getAll() {
        return iPoliceT.findAll();
    }

    @Override
    public PoliceT save(PoliceT article) {
        return iPoliceT.save(article);
    }

    @Override
    public void deleteById(Long id) {
        iPoliceT.deleteById(id);
    }

    @Override
    public Optional<PoliceT> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public PoliceT update(PoliceT stade) {
        Long id = stade.getId();
        Optional<PoliceT> optionalStade = iPoliceT.findById(id);

        if (optionalStade.isPresent()) {
            PoliceT existingStade = optionalStade.get();
            existingStade.setCIN(stade.getCIN());
            existingStade.setEmail(stade.getEmail());
            existingStade.setPrenom(stade.getPrenom());
            existingStade.setName(stade.getName());
            existingStade.setPasssword(stade.getPasssword());
            return iPoliceT.save(existingStade);
        } else {
            // Stade with the given ID does not exist
            System.out.println("Police Terrain with ID " + id + " does not exist");
            return null;
        }    }

}

