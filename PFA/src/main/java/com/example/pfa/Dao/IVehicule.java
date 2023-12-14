package com.example.pfa.Dao;

import com.example.pfa.Model.User;
import com.example.pfa.Model.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "vehicules", path = "vehicule")

public interface IVehicule extends JpaRepository<Vehicule, Long> {
}
