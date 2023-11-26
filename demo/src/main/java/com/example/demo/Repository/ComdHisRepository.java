package com.example.demo.Repository;

import com.example.demo.model.Client;
import com.example.demo.model.Commandes_Historique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "cmdHis", path = "cmdHis")

public interface ComdHisRepository extends JpaRepository<Commandes_Historique, Long> {
}
