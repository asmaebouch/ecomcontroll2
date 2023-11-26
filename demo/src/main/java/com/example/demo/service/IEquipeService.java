package com.example.demo.service;

import com.example.demo.model.Client;
import com.example.demo.model.Equipe;

import java.util.List;
import java.util.Optional;

public interface IEquipeService {
    List<Equipe> getAll();
    Equipe save(Equipe article);
    void deleteById(Long id);
    Optional<Equipe> findById(Long id);
    Equipe update(Equipe stade);
}
