package com.example.tp3.dao;

import com.example.tp3.service.model.Article;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DaoImp implements  IDao{
   private static final List<Article> database = new ArrayList<>
           (Arrays.asList(
               new Article(1L,"PC PORTABLE HP 17",15000d,10d) ,
                   new Article(2L,"ECRAN",15000d,10d) ,
                   new Article(3L,"CAAMERAA LG",3000d,10d) ,
                   new Article(4L,"Souris",200d,10d)
                   ));



    @Override
    public Article findById(Long id) {
        return database.stream().filter(a -> a.
                );
    }

    @Override
    public List<Article> findAll() {
        return null;
    }

    @Override
    public void save(Article article) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
