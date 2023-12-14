package com.example.clientservice2.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientCommand {
private Long id;
private String NomClient;
private String email;
    private String libelle;

    private String description;

    private double price;


}
