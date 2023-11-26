package com.example.demo.controller;

import com.example.demo.Repository.StadeRepository;
import com.example.demo.model.Stade;
import com.example.demo.service.IstadeService;
import com.example.demo.service.StadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/eco")

public class StadeController {
@Autowired
    StadeRepository stadeRepository;
@Autowired
IstadeService stadeService;

    @GetMapping
    public ResponseEntity<List<Stade>> getAllStades() {
        List<Stade> stades = stadeRepository.findAll();
        return new ResponseEntity<>(stades, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Stade> getStadeById(@PathVariable Long id) {
        Optional<Stade> stadeOptional = stadeRepository.findById(id);

        if (stadeOptional.isPresent()) {
            Stade stade = stadeOptional.get();
            return new ResponseEntity<>(stade, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/Save")
    public Stade registreForm(@RequestBody Stade stade){
        System.out.println(stade.toString());
        return stadeService.registreStade(stade);
    }
    @DeleteMapping ("/{id}")
    public void registreDelete(@PathVariable Long id){
        stadeService.deleteSade(id);
    }
    @PutMapping("/updateStade")
    public Stade updateStade(@RequestBody Stade stade){
        System.out.println(stade.toString());
        return stadeService.update(stade);
    }
}
