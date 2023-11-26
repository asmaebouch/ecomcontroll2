package com.example.demo.Repository;

import com.example.demo.model.Billet;
import com.example.demo.model.Catégorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "catégories", path = "cat")
public interface CatégorieRepository extends JpaRepository<Catégorie, Long> {
}
