package com.gestion.gestiondeprojetstage.Controller;

import com.gestion.gestiondeprojetstage.Entity.FormJuridique;
import com.gestion.gestiondeprojetstage.Entity.SecateursActivity;
import com.gestion.gestiondeprojetstage.service.FormJuridiqueService;
import com.gestion.gestiondeprojetstage.service.SecteurActvity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController

public class FormJuridiqueController {
    @Autowired
    private FormJuridiqueService formJuridiqueService;
    @PostMapping("/registreFormJuridique")
    @PreAuthorize("hasRole('Admin')")
    public FormJuridique registreForm(@RequestBody FormJuridique formJuridique){
        return formJuridiqueService.registreForm(formJuridique);
    }
    @GetMapping("/formJuridique")
    @PreAuthorize("hasRole('Admin')")
    public List<String> getForm() {
        List<FormJuridique> secteurs = formJuridiqueService.getForm();
        List<String> secteurNames = new ArrayList<>();

        for (FormJuridique secteur : secteurs) {
            secteurNames.add(secteur.getNom());
        }

        return secteurNames;
    }
    @GetMapping("/formJuridique2")
    @PreAuthorize("hasRole('Admin')")
    public List<FormJuridique> getForm2() {
        return formJuridiqueService.getForm();
    }
    @DeleteMapping("/deleteForme")
    @PreAuthorize("hasRole('Admin')")
    public void deleteForme(@RequestParam Integer id){
        formJuridiqueService.deleteForme(id);
    }




}
