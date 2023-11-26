package com.gestion.gestiondeprojetstage.Repository;

import com.gestion.gestiondeprojetstage.Entity.SousProjet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@RepositoryRestResource
public interface SousProjetRepository extends JpaRepository<SousProjet, Integer> {
    SousProjet findById(Long id);

    SousProjet findByCode(String secteurActiviteId);
}
