package com.example.pfa.Controller;

import com.example.pfa.Model.FicheDeRecherche;
import com.example.pfa.Model.PoliceT;
import com.example.pfa.Service.IFiche;
import com.example.pfa.Service.IPoliceTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/policet")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = {"Access-Control-Allow-Origin", "Content-Type"})
public class PoliceTController {
    @Autowired
    IPoliceTService iPoliceTService;
    @GetMapping
    public ResponseEntity<List<PoliceT>> getAllStades() {
        List<PoliceT> stades = iPoliceTService.getAll();
        return new ResponseEntity<>(stades, HttpStatus.OK);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    public ResponseEntity<PoliceT> registreForm(@RequestBody PoliceT stade){
        System.out.println(stade.toString());
        return new ResponseEntity<>(iPoliceTService.save(stade), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public void Delete(@PathVariable Long id){
        iPoliceTService.deleteById(id);
    }
    @PutMapping("/updatePolice")
    public PoliceT updateStade(@RequestBody PoliceT stade){
        System.out.println(stade.toString());
        return iPoliceTService.update(stade);
    }



}
