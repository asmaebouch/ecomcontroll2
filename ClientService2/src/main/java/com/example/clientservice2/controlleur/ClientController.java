package com.example.clientservice2.controlleur;

import com.example.clientservice2.model.Client;
import com.example.clientservice2.model.ClientCommand;
import com.example.clientservice2.model.Command;
import com.example.clientservice2.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cli1")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = {"Access-Control-Allow-Origin", "Content-Type"})

public class ClientController {


    @Autowired
    IClientService iClientService;
    /*@Autowired
    RestTemplate restTemplate;*/
    @GetMapping
    public ResponseEntity<List<Client>> getAllStades() {
        List<Client> stades = iClientService.getAll();
        return new ResponseEntity<>(stades, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    public ResponseEntity<Client> registreForm(@RequestBody Client stade){
        System.out.println(stade.toString());
        return new ResponseEntity<>(iClientService.save(stade), HttpStatus.OK);
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
