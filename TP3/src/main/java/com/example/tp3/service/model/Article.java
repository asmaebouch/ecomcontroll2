package com.example.tp3.service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article implements Serializable {

    public Article(Long id, String description, Double price, Double quantity) {
    }
}
