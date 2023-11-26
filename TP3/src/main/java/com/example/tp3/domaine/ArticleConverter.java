 package com.example.tp3.domaine;

import com.example.tp3.service.model.Article;

public class ArticleConverter {
public static Article toBO(ArticleDTO dto)
{
    if(dto==null) return null;
    return new Article(dto.getId(),dto.getDescription(),dto.getPrice(),dto.getQuantity());

}








}
