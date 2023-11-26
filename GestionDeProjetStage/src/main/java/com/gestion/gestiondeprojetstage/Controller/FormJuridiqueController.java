package com.gestion.gestiondeprojetstage.Controller;

import com.gestion.gestiondeprojetstage.Entity.FormJuridique;
import com.gestion.gestiondeprojetstage.Repository.FormJuridiqueRpository;
import com.gestion.gestiondeprojetstage.service.FormJuridiqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController

public class FormJuridiqueController {
    @Autowired
    private FormJuridiqueService formJuridiqueService;
    @Autowired
    private FormJuridiqueRpository formJuridiqueRpository;
    @PostMapping("/registreFormJuridique")
    @PreAuthorize("hasRole('Admin')")
    public FormJuridique registreForm(@RequestBody FormJuridique formJuridique){
        System.out.println(formJuridique.toString());
        return formJuridiqueService.registreForm(formJuridique);
    }
    @GetMapping("/formJuridique")
    @PreAuthorize("hasRole('Admin')")
    public List<String> getForm() {
        List<FormJuridique> secteurs = formJuridiqueService.getForm2();
        System.out.println(secteurs.toString());
        List<String> secteurNames = new ArrayList<>();
        for (FormJuridique secteur : secteurs) {
            secteurNames.add(secteur.getNom());
        }
        return secteurNames;
    }



    /* @GetMapping("/formJuridique2")
    @PreAuthorize("hasRole('Admin')")
    public List<FormJuridique> getForm2(){
        List<FormJuridique> formJuridiques = formJuridiqueService.getForm();
        // Log the formJuridiques to check if it contains data.
        System.out.println("FormJuridiques: {}"+ formJuridiques);
        return formJuridiques;
    }*/
   @GetMapping("/formJuridique2")
   @PreAuthorize("hasRole('Admin')")
    public ResponseEntity<Page<FormJuridique>> getForm2(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<FormJuridique> clientPage = formJuridiqueService.getForm(pageable);
        System.out.println("clients: {}"+ clientPage);

        return ResponseEntity.ok(clientPage);
    }

    @DeleteMapping("/deleteForme")
    @PreAuthorize("hasRole('Admin')")
    public void deleteForme(@RequestParam Long id){

        formJuridiqueService.deleteForme(id);
    }
    @PutMapping("/updateForm")
    @PreAuthorize("hasRole('Admin')")
    public FormJuridique updateForm(@RequestBody FormJuridique client){

        return   formJuridiqueService.updateFormJurridique(client);

    }



}
