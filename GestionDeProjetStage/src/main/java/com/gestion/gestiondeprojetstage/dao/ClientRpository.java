package com.gestion.gestiondeprojetstage.dao;

import com.gestion.gestiondeprojetstage.Entity.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ClientRpository extends CrudRepository<Client,Integer> {
}
