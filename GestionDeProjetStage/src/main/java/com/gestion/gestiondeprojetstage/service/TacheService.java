package com.gestion.gestiondeprojetstage.service;

import com.gestion.gestiondeprojetstage.Entity.*;
import com.gestion.gestiondeprojetstage.Repository.SousProjetRepository;
import com.gestion.gestiondeprojetstage.Repository.TacheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TacheService {
    @Autowired
    private TacheRepository tacheRepository;
    @Autowired
private SousProjetRepository sousProjetRepository;
    public Tache registreTache(Tache tache){
       String secteurActiviteId = null;
        if (tache.getSousProjet()!= null) {
            secteurActiviteId = tache.getSousProjet().getCode();
        }
        SousProjet optionalSecteurActivity = null;
        if (secteurActiviteId != null) {
            optionalSecteurActivity = sousProjetRepository.findByCode(secteurActiviteId);
            tache.setSousProjet(optionalSecteurActivity);

            optionalSecteurActivity.getTache().add(tache);
        }
        else {
            tacheRepository.save(tache);
        }
         tacheRepository.save(tache);
        return  tache;
    }
    public List<Tache> getTache(){
        return tacheRepository.findAll();
    }

}
