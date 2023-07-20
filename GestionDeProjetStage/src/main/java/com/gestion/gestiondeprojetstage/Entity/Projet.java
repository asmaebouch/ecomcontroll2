package com.gestion.gestiondeprojetstage.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Projet {
    @Id     @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String code;
    @ManyToOne
    private Client client;
    private Date Date_Debut;
    private Date Date_Fin;
    private StatutProjet statutProjet;
    @ManyToOne
    private User2 user2;
    private  Date creeLe;
    private Float Budget;



}
