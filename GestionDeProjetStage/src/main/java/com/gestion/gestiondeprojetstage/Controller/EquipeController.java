package com.gestion.gestiondeprojetstage.Controller;

import com.gestion.gestiondeprojetstage.Entity.Equipe;
import com.gestion.gestiondeprojetstage.service.EquipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class EquipeController {
    @Autowired
    EquipeService equipeService;
    @PostMapping("/registreEquipe")
    @PreAuthorize("hasRole('User')")
    public Equipe registreEquipe(@RequestBody Equipe equipe) {
        System.out.println("bbbb");
        return equipeService.registreEquipe(equipe);
    }
    @GetMapping("/getEquipe" )
    @PreAuthorize("hasRole('User')")

    public List<Equipe> clientList(){
        return equipeService.getEquipe() ;
    }
}
