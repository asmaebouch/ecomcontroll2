package com.example.demo.controller;

import com.example.demo.model.Billet;
import com.example.demo.model.Match;
import com.example.demo.service.IBilletService;
import com.example.demo.service.IMatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bill")
public class BilletController {
    @Autowired
    IBilletService iBilletService;

    @GetMapping
    public ResponseEntity<List<Billet>> getAllStades() {
        List<Billet> stades = iBilletService.getAll();
        return new ResponseEntity<>(stades, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Billet> getStadeById(@PathVariable Long id) {
        Optional<Billet> stadeOptional = iBilletService.findById(id);

        if (stadeOptional.isPresent()) {
            Billet stade = stadeOptional.get();
            return new ResponseEntity<>(stade, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/Save")
    public Billet registreForm(@RequestBody Billet stade){
        System.out.println(stade.toString());
        return iBilletService.save(stade);
    }
    @DeleteMapping ("/{id}")
    public void registreDelete(@PathVariable Long id){
        iBilletService.deleteById(id);
    }
    @PutMapping("/update")
    public Billet updateStade(@RequestBody Billet stade){
        System.out.println(stade.toString());
        return iBilletService.update(stade);
    }



}
