package com.gestion.gestiondeprojetstage.Controller;

import com.gestion.gestiondeprojetstage.Entity.SousProjet;
import com.gestion.gestiondeprojetstage.service.SousProjetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController

public class SousProjetController {
    @Autowired
    private SousProjetService  sousProjetService;

    @PostMapping("/registreSousProjet")
    @PreAuthorize("hasRole('User')")
    public SousProjet registreProjet(@RequestBody SousProjet sousProjet){


        return sousProjetService.registreSousProjet(sousProjet);
    }
    @GetMapping("/getSousProjets" )
    @PreAuthorize("hasRole('User')")

    public List<SousProjet> SousProjetList(){
        return sousProjetService.getSousProjet() ;
    }
    @PutMapping("/updateSousProjet")
    @PreAuthorize("hasRole('User')")
    public SousProjet updateSousProjet(@RequestBody SousProjet client){

        return   sousProjetService.updateSousProjet(client);

    }
    @DeleteMapping("/deleteSousProjet")
    @PreAuthorize("hasRole('User')")
    public void deleteSousProjet(@RequestParam Long id) throws Exception {

        sousProjetService.deleteSousProjet(id);
    }
    @GetMapping("/SousProjtList")
    @PreAuthorize("hasRole('User')")
    public List<String> getSousProjet() {
        List<SousProjet> secteurs = sousProjetService.getClients2();
        List<String> secteurNames = new ArrayList<>();

        for (SousProjet secteur : secteurs) {
            secteurNames.add(secteur.getCode());
        }

        return secteurNames;
    }

}
