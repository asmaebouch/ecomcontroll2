package com.example.pfa.Dao;

import com.example.pfa.Model.Personne;
import com.example.pfa.Model.PoliceBri;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "policebris", path = "policebri")

public interface IPoliceB extends JpaRepository<PoliceBri, Long> {
}
