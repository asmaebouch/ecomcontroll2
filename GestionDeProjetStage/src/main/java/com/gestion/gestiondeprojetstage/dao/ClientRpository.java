package com.gestion.gestiondeprojetstage.dao;

import com.gestion.gestiondeprojetstage.Entity.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@RepositoryRestResource
public interface ClientRpository extends CrudRepository<Client,Integer> {
    Client findById(Long id);

    Client findByNom(String clientNom);
    Page<Client> findAll(Pageable pageable);


    void deleteById(Long id);

    boolean existsByCode(String code);

    boolean existsByTelephone(String telephone);
}
