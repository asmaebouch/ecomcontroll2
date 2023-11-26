package com.gestion.gestiondeprojetstage.Repository;

import com.gestion.gestiondeprojetstage.Entity.SecateursActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@RepositoryRestResource
public interface SecteurActivityRepository extends JpaRepository<SecateursActivity, Long> {
    SecateursActivity findByNom(String activite);
}
