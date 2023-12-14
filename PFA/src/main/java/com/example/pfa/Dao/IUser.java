package com.example.pfa.Dao;

import com.example.pfa.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "users", path = "user")

public interface IUser extends JpaRepository<User, Long> {
}
