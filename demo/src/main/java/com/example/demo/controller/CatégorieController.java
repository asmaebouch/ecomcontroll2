package com.example.demo.controller;

import com.example.demo.model.Catégorie;
import com.example.demo.model.Client;
import com.example.demo.service.ICatégrieService;
import com.example.demo.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//cat
@RestController
@RequestMapping("/cat")
public class CatégorieController {



    @Autowired
    ICatégrieService iCatégrieService;

    @GetMapping
    public ResponseEntity<List<Catégorie>> getAllStades() {
        List<Catégorie> stades = iCatégrieService.getAll();
        return new ResponseEntity<>(stades, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Catégorie> getCatégorieById(@PathVariable Long id) {
        Optional<Catégorie> stadeOptional = iCatégrieService.findById(id);

        if (stadeOptional.isPresent()) {
            Catégorie stade = stadeOptional.get();
            return new ResponseEntity<>(stade, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/Save")
    public Catégorie registreForm(@RequestBody Catégorie stade){
        System.out.println(stade.toString());
        return iCatégrieService.save(stade);
    }
    @DeleteMapping ("/{id}")
    public void Delete(@PathVariable Long id){
        iCatégrieService.deleteById(id);
    }
    @PutMapping("/update")
    public Catégorie update(@RequestBody Catégorie stade){
        System.out.println(stade.toString());
        return iCatégrieService.update(stade);
    }
}
