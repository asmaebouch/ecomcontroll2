package com.example.gestionticket3.Entity;

import lombok.Data;

@Data
public class Product {
private Long id;
private String name;
public Product()
{
}
public Product(Long id,String name){
    this.id=id;
    this.name=name;
}
public Long gtId(){
    return id;
}
public String getName()
{
    return  name;
}
public void setName(String name){
    this.name=name;
}
}
