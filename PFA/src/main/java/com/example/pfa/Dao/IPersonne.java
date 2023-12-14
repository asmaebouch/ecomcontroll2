package com.example.pfa.Dao;

import com.example.pfa.Model.FicheDeRecherche;
import com.example.pfa.Model.Personne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "personnes", path = "personne")

public interface IPersonne extends JpaRepository<Personne, Long> {
}
