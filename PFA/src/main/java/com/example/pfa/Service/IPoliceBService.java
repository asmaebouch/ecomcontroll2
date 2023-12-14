package com.example.pfa.Service;

import com.example.pfa.Model.FicheDeRecherche;
import com.example.pfa.Model.Personne;
import com.example.pfa.Model.PoliceBri;

import java.util.List;
import java.util.Optional;

public interface IPoliceBService {
    List<PoliceBri> getAll();
    PoliceBri save(PoliceBri article);
    void deleteById(Long id);
    Optional<PoliceBri> findById(Long id);
    PoliceBri update(PoliceBri stade);
}
