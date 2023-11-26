package com.example.demo.service;

import com.example.demo.model.Billet;
import com.example.demo.model.Match;

import java.util.List;
import java.util.Optional;

public interface IBilletService {

    List<Billet> getAll();
    Billet save(Billet article);
    void deleteById(Long id);
    Optional<Billet> findById(Long id);
    Billet update(Billet stade);
}
