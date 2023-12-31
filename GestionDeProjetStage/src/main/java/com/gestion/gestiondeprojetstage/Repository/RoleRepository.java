package com.gestion.gestiondeprojetstage.Repository;

import com.gestion.gestiondeprojetstage.Entity.Projet;
import com.gestion.gestiondeprojetstage.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@RepositoryRestResource
public interface RoleRepository extends JpaRepository<Role, String> {
}
