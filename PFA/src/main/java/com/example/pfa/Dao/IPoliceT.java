package com.example.pfa.Dao;

import com.example.pfa.Model.PoliceT;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "policets", path = "policet")

public interface IPoliceT extends JpaRepository<PoliceT, Long> {
}
