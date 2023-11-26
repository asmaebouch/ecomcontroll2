package com.example.demo.Repository;

import com.example.demo.model.Client;
import com.example.demo.model.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "matchs", path = "mat")

public interface MatchRepository extends JpaRepository<Match, Long> {
}
