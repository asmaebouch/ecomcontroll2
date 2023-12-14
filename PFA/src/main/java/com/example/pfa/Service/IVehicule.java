package com.example.pfa.Service;

import com.example.pfa.Model.User;
import com.example.pfa.Model.Vehicule;

import java.util.List;
import java.util.Optional;

public interface IVehicule {
    List<Vehicule> getAll();
    Vehicule save(Vehicule article);
    void deleteById(Long id);
    Optional<Vehicule> findById(Long id);
    Vehicule update(Vehicule stade);
}

