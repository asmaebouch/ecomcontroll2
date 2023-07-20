package com.gestion.gestiondeprojetstage.service;

import com.gestion.gestiondeprojetstage.Entity.SecateursActivity;
import com.gestion.gestiondeprojetstage.Entity.Tache;
import com.gestion.gestiondeprojetstage.Repository.SecteurActivityRepository;
import com.gestion.gestiondeprojetstage.Repository.TacheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TacheService {
    @Autowired
    private TacheRepository tacheRepository;
    public Tache registreTache(Tache tache){
        return tacheRepository.save(tache);
    }
    public List<Tache> getTache(){
        return tacheRepository.findAll();
    }

}
