package com.gestion.gestiondeprojetstage.dao;

import com.gestion.gestiondeprojetstage.Entity.ERole;
import com.gestion.gestiondeprojetstage.Entity.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleDao extends CrudRepository<Role,String> {


    Role findByRoleName(String roles);
}
