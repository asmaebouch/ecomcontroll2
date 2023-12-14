package com.example.clientservice2.Dao;

import com.example.clientservice2.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "clients", path = "cli1")
public interface ClientDao extends JpaRepository<Client, Long> {
}
