package com.gestion.gestiondeprojetstage.Controller;

import com.gestion.gestiondeprojetstage.Entity.Projet;
import com.gestion.gestiondeprojetstage.Entity.SousProjet;
import com.gestion.gestiondeprojetstage.service.ProjetService;
import com.gestion.gestiondeprojetstage.service.SousProjetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
