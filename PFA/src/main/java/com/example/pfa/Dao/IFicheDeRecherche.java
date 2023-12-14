package com.example.pfa.Dao;

import com.example.pfa.Model.FicheDeRecherche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "fichederecherche", path = "ficher")

public interface IFicheDeRecherche extends JpaRepository<FicheDeRecherche, Long> {
}
