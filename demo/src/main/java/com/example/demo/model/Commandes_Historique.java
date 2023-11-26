package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Commandes_Historique {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
@OneToMany
    private List<Billet> billetList;
    private Date date;
    private  Double Prix_total;
    private Statut_commande statut_commande;
}
