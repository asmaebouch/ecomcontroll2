package com.example.demo.Repository;

import com.example.demo.model.Billet;
import com.example.demo.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "clients", path = "cli")

public interface ClientRepository extends JpaRepository<Client, Long> {
}
