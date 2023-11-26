package com.gestion.gestiondeprojetstage.Controller;

import com.gestion.gestiondeprojetstage.Entity.Tache;
import com.gestion.gestiondeprojetstage.service.TacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.List;

@RestController

public  class TacheController implements Serializable {
    @Autowired
    private TacheService tacheService;

    @PostMapping("/registreTache")
    @PreAuthorize("hasRole('User')")
    public Tache registreTache(@RequestBody Tache tache){
      //  tache.setSousProjet(tache.getSousProjet());
        return tacheService.registreTache(tache );
    }
    @GetMapping("/getTache" )
    @PreAuthorize("hasRole('User')")

    public List<Tache> TacheList(){
        return tacheService.getTache();
    }
}