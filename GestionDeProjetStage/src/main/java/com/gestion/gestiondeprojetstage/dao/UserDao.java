package com.gestion.gestiondeprojetstage.dao;

import com.gestion.gestiondeprojetstage.Entity.User2;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends CrudRepository<User2,String> {
    void deleteByuserName(String userName);

    User2 findByUserName(String userName);
    //  Optional<User2> findByUsername(String username);

   // Boolean existsByUsername(String username);


}
