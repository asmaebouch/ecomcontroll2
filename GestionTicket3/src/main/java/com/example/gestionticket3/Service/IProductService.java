package com.example.gestionticket3.Service;

import com.example.gestionticket3.Entity.Product;

import java.util.List;

public interface IProductService {
    Product getById(Long id);
    List<Product> getAll();
    void create(Product product);
    void update(Long id,Product product);
    void delete(Long id);

}
