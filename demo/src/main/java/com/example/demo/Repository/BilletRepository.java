package com.example.demo.Repository;

import com.example.demo.model.Billet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "billets", path = "bill")
public interface BilletRepository  extends JpaRepository<Billet, Long> {
}
