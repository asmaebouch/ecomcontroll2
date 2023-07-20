package com.gestion.gestiondeprojetstage.Repository;

import com.gestion.gestiondeprojetstage.Entity.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
@CrossOrigin("*")
@RepositoryRestResource
//spring datarest
public interface ClientRepository extends JpaRepository<Client, Long>  {
@RestResource(path = "/byCode")
//http://localhost:8080/clients/search/byCode?mc=kshd
    public List<Client> findByCode(@Param("mc") String code);
@RestResource(path = "/byCodePage")
//http://localhost:8080/clients/search/byCode?mc=kshd
    public Page<Client> findByCode(@Param("mc") String code, Pageable pageable);

}
