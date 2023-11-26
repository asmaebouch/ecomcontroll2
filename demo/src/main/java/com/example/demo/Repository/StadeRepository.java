package com.example.demo.Repository;

import com.example.demo.domaine.stadeDTO;
import com.example.demo.model.Stade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource (collectionResourceRel = "stades", path = "eco")
public interface StadeRepository extends JpaRepository<Stade, Long> {

}
