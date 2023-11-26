package com.example.gestionticket3.Service;

import com.example.gestionticket3.Entity.Article;

import java.util.List;

public interface IService {
    List<Article> getAll();
    void save(Article article);
    void deleteById(Long id);
    Article findById(Long id);

}
