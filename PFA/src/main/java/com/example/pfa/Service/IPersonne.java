package com.example.pfa.Service;

import com.example.pfa.Model.FicheDeRecherche;
import com.example.pfa.Model.Personne;

import java.util.List;
import java.util.Optional;

public interface IPersonne {
    List<Personne> getAll();
    Personne save(Personne article);
    void deleteById(Long id);
    Optional<Personne> findById(Long id);
    Personne update(Personne stade);
}
