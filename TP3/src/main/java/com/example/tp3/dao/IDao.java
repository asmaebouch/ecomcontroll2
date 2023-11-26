package com.example.tp3.dao;

import com.example.tp3.service.model.Article;

import java.util.List;

public interface IDao {
    Article findById(Long id);
    List<Article> findAll();
    void save(Article article);
    void deleteById(Long id);


}
