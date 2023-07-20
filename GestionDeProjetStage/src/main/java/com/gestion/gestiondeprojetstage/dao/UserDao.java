package com.gestion.gestiondeprojetstage.dao;

import com.gestion.gestiondeprojetstage.Entity.User2;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Repository
public interface UserDao extends CrudRepository<User2,String> {
  //  Optional<User2> findByUsername(String username);

   // Boolean existsByUsername(String username);


}
