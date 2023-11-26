package com.gestion.gestiondeprojetstage.Repository;

import com.gestion.gestiondeprojetstage.Entity.FormJuridique;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@RepositoryRestResource
public interface FormJuridiqueRpository extends JpaRepository<FormJuridique, Long> {

    FormJuridique findByNom(String formJuridiqueNom);
    Page<FormJuridique> findAll(Pageable pageable);

}
