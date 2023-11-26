package com.example.demo.service;

import com.example.demo.model.Catégorie;
import com.example.demo.model.Client;

import java.util.List;
import java.util.Optional;

public interface ICatégrieService {
    List<Catégorie> getAll();
    Catégorie save(Catégorie article);
    void deleteById(Long id);
    Optional<Catégorie> findById(Long id);
    Catégorie update(Catégorie stade);
}
