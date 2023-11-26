package com.example.demo.service;

import com.example.demo.model.Client;

import java.util.List;
import java.util.Optional;

public interface IClientService {
    List<Client> getAll();
    Client save(Client article);
    void deleteById(Long id);
    Optional<Client> findById(Long id);
    Client update(Client stade);
}
