package com.example.demo.service;

import com.example.demo.model.Catégorie;
import com.example.demo.model.Match;

import java.util.List;
import java.util.Optional;

public interface IMatchService {

    List<Match> getAll();
    Match save(Match article);
    void deleteById(Long id);
    Optional<Match> findById(Long id);
    Match update(Match stade);
}
