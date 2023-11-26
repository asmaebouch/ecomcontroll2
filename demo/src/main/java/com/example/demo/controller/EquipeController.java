package com.example.demo.controller;

import com.example.demo.model.Client;
import com.example.demo.model.Equipe;
import com.example.demo.service.IClientService;
import com.example.demo.service.IEquipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/equ")
public class EquipeController {

    @Autowired
    IEquipeService iEquipeService;
    @GetMapping
    public ResponseEntity<List<Equipe>> getAllEquipe() {
        List<Equipe> stades = iEquipeService.getAll();
        return new ResponseEntity<>(stades, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Equipe> getEquipeById(@PathVariable Long id) {
        Optional<Equipe> stadeOptional = iEquipeService.findById(id);

        if (stadeOptional.isPresent()) {
            Equipe stade = stadeOptional.get();
            return new ResponseEntity<>(stade, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/Save")
    public Equipe registreForm(@RequestBody Equipe stade){
        System.out.println(stade.toString());
        return iEquipeService.save(stade);
    }
    @DeleteMapping ("/{id}")
    public void Delete(@PathVariable Long id){
        iEquipeService.deleteById(id);
    }
    @PutMapping("/update")
    public Equipe updateStade(@RequestBody Equipe stade){
        System.out.println(stade.toString());
        return iEquipeService.update(stade);
    }


}
