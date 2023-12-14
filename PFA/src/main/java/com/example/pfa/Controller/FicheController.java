package com.example.pfa.Controller;

import com.example.pfa.Model.FicheDeRecherche;
import com.example.pfa.Service.IFiche;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ficher")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = {"Access-Control-Allow-Origin", "Content-Type"})

public class FicheController {

    @Autowired
    IFiche iFiche;

    @GetMapping
    public ResponseEntity<List<FicheDeRecherche>> getAllStades() {
        List<FicheDeRecherche> stades = iFiche.getAll();
        return new ResponseEntity<>(stades, HttpStatus.OK);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    public ResponseEntity<FicheDeRecherche> registreForm(@RequestBody FicheDeRecherche stade){
        System.out.println(stade.toString());
        return new ResponseEntity<>(iFiche.save(stade), HttpStatus.OK);
    }
    @DeleteMapping ("/{id}")
    public void Delete(@PathVariable Long id){
        iFiche.deleteById(id);
    }
    @PutMapping("/updateFiche")
    public FicheDeRecherche updateStade(@RequestBody FicheDeRecherche stade){
        System.out.println(stade.toString());
        return iFiche.update(stade);
    }






}
