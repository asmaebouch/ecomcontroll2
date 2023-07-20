package com.gestion.gestiondeprojetstage.service;

import com.gestion.gestiondeprojetstage.Entity.Projet;
import com.gestion.gestiondeprojetstage.Entity.SousProjet;
import com.gestion.gestiondeprojetstage.Repository.ProjetRepository;
import com.gestion.gestiondeprojetstage.Repository.SousProjetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class SousProjetService {
    @Autowired
    private SousProjetRepository sousProjetRepository;
    public SousProjet registreSousProjet(SousProjet sousProjet){

        return sousProjetRepository.save(sousProjet);
    }
    public List<SousProjet> getSousProjet()
    {
        return (List<SousProjet>) sousProjetRepository.findAll();
    }
}
