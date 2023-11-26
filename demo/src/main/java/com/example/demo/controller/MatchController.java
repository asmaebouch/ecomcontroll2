package com.example.demo.controller;

import com.example.demo.Repository.StadeRepository;
import com.example.demo.model.Match;
import com.example.demo.model.Stade;
import com.example.demo.service.IMatchService;
import com.example.demo.service.IstadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/mat")
public class MatchController {
@Autowired
IMatchService iMatchService;

    @GetMapping
    public ResponseEntity<List<Match>> getAllStades() {
        List<Match> stades = iMatchService.getAll();
        return new ResponseEntity<>(stades, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Match> getStadeById(@PathVariable Long id) {
        Optional<Match> stadeOptional = iMatchService.findById(id);

        if (stadeOptional.isPresent()) {
            Match stade = stadeOptional.get();
            return new ResponseEntity<>(stade, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/Save")
    public Match registreForm(@RequestBody Match stade){
        System.out.println(stade.toString());
        return iMatchService.save(stade);
    }
    @DeleteMapping ("/{id}")
    public void registreDelete(@PathVariable Long id){
        iMatchService.deleteById(id);
    }
    @PutMapping("/update")
    public Match updateStade(@RequestBody Match stade){
        System.out.println(stade.toString());
        return iMatchService.update(stade);
    }
}
