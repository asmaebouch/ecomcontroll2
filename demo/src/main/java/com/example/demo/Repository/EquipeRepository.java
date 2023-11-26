package com.example.demo.Repository;

import com.example.demo.model.Client;
import com.example.demo.model.Equipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "equipes", path = "equ")

public interface EquipeRepository extends JpaRepository<Equipe, Long> {
}
