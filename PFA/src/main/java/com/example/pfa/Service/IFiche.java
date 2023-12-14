package com.example.pfa.Service;

import com.example.pfa.Model.FicheDeRecherche;

import java.util.List;
import java.util.Optional;

public interface IFiche {
    List<FicheDeRecherche> getAll();
    FicheDeRecherche save(FicheDeRecherche article);
    void deleteById(Long id);
    Optional<FicheDeRecherche> findById(Long id);
    FicheDeRecherche update(FicheDeRecherche stade);

}
