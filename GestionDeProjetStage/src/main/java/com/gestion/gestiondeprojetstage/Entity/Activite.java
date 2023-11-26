package com.gestion.gestiondeprojetstage.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Activite implements Serializable {
    @Id     @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
   /* @ManyToOne(cascade = CascadeType.ALL)
    private SousProjet sousProjet;
    */

    private String Titre;
    private Date  date_Debut;
    private Date Date_Fin;
    private Statut_Tache statutTache;
    @ManyToOne
    private Tache tache;

}
