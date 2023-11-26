package com.gestion.gestiondeprojetstage.Controller;

import com.gestion.gestiondeprojetstage.Entity.SecateursActivity;
import com.gestion.gestiondeprojetstage.Repository.SecteurActivityRepository;
import com.gestion.gestiondeprojetstage.service.SecteurActvity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController

public class SecteurActiviteController {
    @Autowired
    private SecteurActvity secteurActvity;
    @Autowired
    private SecteurActivityRepository secteurActivityRepository;
    @PostMapping("/registreSecteurActivite")
    @PreAuthorize("hasRole('Admin')")
    public SecateursActivity registreClient(@RequestBody SecateursActivity secateursActivity){
        return secteurActvity.registreSecteur(secateursActivity);
    }
    @GetMapping("/secteurs")
    @PreAuthorize("hasRole('Admin')")
    public List<SecateursActivity> getSecteurs() {
       /* List<SecateursActivity> secteurs = secteurActvity.getSecteurs();
        List<String> secteurNames = new ArrayList<>();

        for (SecateursActivity secteur : secteurs) {
            secteurNames.add(secteur.getNom());
        }*/

        return secteurActvity.getSecteurs();
    }
    @GetMapping("/secteurs2")
    @PreAuthorize("hasRole('Admin')")
    public List<String> getSecteurs2() {
       List<SecateursActivity> secteurs = secteurActvity.getSecteurs();
        List<String> secteurNames = new ArrayList<>();

        for (SecateursActivity secteur : secteurs) {
            secteurNames.add(secteur.getNom());
        }

        return secteurNames;
    }
    @DeleteMapping("/deleteSecteur")
    @PreAuthorize("hasRole('Admin')")
    public void deleteSecteur(@RequestParam Long id){
    /*    Optional<SecateursActivity> formJuridique = secteurActivityRepository.findById(id);

        // Supprimer le FormJuridique de tous les clients associés
        for (Client client : formJuridique.get().getClients()) {
            client.setFormJuridique(null); // Dissocier le FormJuridique
        }*/
        secteurActvity.deleteSecteur(id);
    }


}
