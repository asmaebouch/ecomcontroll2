package com.example.demo.controller;

import com.example.demo.Repository.StadeRepository;
import com.example.demo.model.Client;
import com.example.demo.model.Stade;
import com.example.demo.service.IClientService;
import com.example.demo.service.IstadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cli")
public class ClientController {

    @Autowired
    IClientService iClientService;

    @GetMapping
    public ResponseEntity<List<Client>> getAllStades() {
        List<Client> stades = iClientService.getAll();
        return new ResponseEntity<>(stades, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Client> getStadeById(@PathVariable Long id) {
        Optional<Client> stadeOptional = iClientService.findById(id);

        if (stadeOptional.isPresent()) {
            Client stade = stadeOptional.get();
            return new ResponseEntity<>(stade, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/Save")
    public Client registreForm(@RequestBody Client stade){
        System.out.println(stade.toString());
        return iClientService.save(stade);
    }
    @DeleteMapping ("/{id}")
    public void Delete(@PathVariable Long id){
        iClientService.deleteById(id);
    }
    @PutMapping("/updateClient")
    public Client updateStade(@RequestBody Client stade){
        System.out.println(stade.toString());
        return iClientService.update(stade);
    }
}
