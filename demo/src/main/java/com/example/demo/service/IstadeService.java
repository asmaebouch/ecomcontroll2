package com.example.demo.service;

import com.example.demo.model.Stade;

import java.util.List;

public interface IstadeService {
    List<Stade> getAll();
    void save(Stade article);
    void deleteById(Long id);
    Stade findById(Long id);
    Stade update(Stade stade);
    Stade registreStade(Stade stade);
    void deleteSade(Long id);
}
