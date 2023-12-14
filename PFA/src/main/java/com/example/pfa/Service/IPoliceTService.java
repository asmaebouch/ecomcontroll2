package com.example.pfa.Service;

import com.example.pfa.Model.PoliceBri;
import com.example.pfa.Model.PoliceT;

import java.util.List;
import java.util.Optional;

public interface IPoliceTService {
    List<PoliceT> getAll();
    PoliceT save(PoliceT article);
    void deleteById(Long id);
    Optional<PoliceT> findById(Long id);
    PoliceT update(PoliceT stade);
}
