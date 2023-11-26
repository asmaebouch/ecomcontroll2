package com.gestion.gestiondeprojetstage.Controller;

import com.gestion.gestiondeprojetstage.Entity.Projet;
import com.gestion.gestiondeprojetstage.Repository.ProjetRepository;
import com.gestion.gestiondeprojetstage.dao.ClientRpository;
import com.gestion.gestiondeprojetstage.service.ClientService;
import com.gestion.gestiondeprojetstage.service.ProjetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController

public class ProjetController {
    @Autowired
    private ProjetService projetService;
    @Autowired
    private ClientService clientService;
    @Autowired
    private ClientRpository clientRepository;
    @Autowired
    private ProjetRepository projetRepository;

    @PostMapping("/registreProjet")
    @PreAuthorize("hasRole('Admin')")
    public Projet registreProjet(@RequestBody Projet projet) {



        return                         projetService.registreProjet(projet);

    }

    @GetMapping("/getProjets" )
    @PreAuthorize("hasRole('Admin')")

    public List<Projet> clientList(){
        return projetService.getProjet() ;
    }
    @DeleteMapping("/deleteProjet")
    @PreAuthorize("hasRole('Admin')")
    public void deleteProjet(@RequestParam Long id) throws Exception {

        projetService.deleteProjet(id);
    }
    @PutMapping("/updateProjet")
    @PreAuthorize("hasRole('Admin')")
    public Projet updateProjet(@RequestBody Projet client){

        return   projetService.updateProjet(client);

    }
    @GetMapping("/ProjetList")
    @PreAuthorize("hasAnyRole('Admin', 'User')")
    public List<String> getProjet() {
        List<Projet> secteurs = projetService.getProjet2();
        List<String> secteurNames = new ArrayList<>();

        for (Projet secteur : secteurs) {
            secteurNames.add(secteur.getCode());
        }

        return secteurNames;
    }

}
