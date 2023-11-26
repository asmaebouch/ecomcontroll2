package com.gestion.gestiondeprojetstage.Repository;

import com.gestion.gestiondeprojetstage.Entity.Projet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@RepositoryRestResource
public interface ProjetRepository extends CrudRepository<Projet, Integer> {
    Projet findById(Long id);

    Projet findByCode(String secteurActiviteId);
}
