package com.gestion.gestiondeprojetstage.service;

import com.gestion.gestiondeprojetstage.Entity.*;
import com.gestion.gestiondeprojetstage.Repository.ProjetRepository;
import com.gestion.gestiondeprojetstage.Repository.SousProjetRepository;
import com.gestion.gestiondeprojetstage.Repository.TacheRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service

public class SousProjetService {
    @Autowired
    private SousProjetRepository sousProjetRepository;
    @Autowired
    private ProjetRepository projetRepository;
    @Autowired
    private TacheRepository tacheRepository;
    public SousProjet registreSousProjet(SousProjet sousProjet){
        String sousProjetId = null;
        String formJuridiqueId = null;

        if (sousProjet.getProjet() != null) {
            sousProjetId = sousProjet.getProjet().getCode();
        }

        Projet optionalSousProjet = null;
        FormJuridique existingFormJuridique = null;
        if (sousProjetId != null) {
            optionalSousProjet = projetRepository.findByCode(sousProjetId);
            sousProjet.setProjet(optionalSousProjet);
            optionalSousProjet.getSousProjet().add(sousProjet);
        }
        else {
            sousProjetRepository.save(sousProjet)    ;
        }
        sousProjetRepository.save(sousProjet)    ;
        return sousProjet;
    }
    public List<SousProjet> getSousProjet()
    {
        return (List<SousProjet>) sousProjetRepository.findAll();
    }
    public SousProjet updateSousProjet(SousProjet client){
        Long id = client.getId();
        client.getId();
        SousProjet client1 = sousProjetRepository.findById(id);
        if (client1 == null) {
            System.out.println("eerrrorrr projet no found");
        }
        if (client1 != null) {
            client1.setCode(client.getCode());
            client1.setDate_Fin(client.getDate_Fin());
            client1.setDate_Debut(client.getDate_Debut());
            client1.setDescription(client.getDescription());


            return sousProjetRepository.save(client1);
        }
        return null; // Handle the case where client1 is null
    }
    @Transactional
    public void deleteSousProjet(Long id) throws Exception {
        // Step 1: Retrieve the project to be deleted
        SousProjet projetToDelete = sousProjetRepository.findById(id);
        if (projetToDelete == null) {
            throw new Exception("Project with id " + id + " not found");
        }
        String tacheId = null;

        Projet projet = projetToDelete.getProjet();
        if (projet != null) {
            projet.getSousProjet().remove(projetToDelete);
        }
        // Step 2: Remove the project from the client's list of projects
       Collection<Tache >  tache = projetToDelete.getTache();
            for (Tache taches : tache) {
                taches.setSousProjet(null);
                if (taches.getSousProjet() != null) {
                    tacheId = taches.getSousProjet().getCode();
                }
                tacheRepository.save(taches);

            }
            sousProjetRepository.delete(projetToDelete);
    }
    public List<SousProjet> getClients2()
    {
        return (List<SousProjet>) sousProjetRepository.findAll();
    }
}
