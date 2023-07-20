package com.gestion.gestiondeprojetstage.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ManyToAny;

import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Tache implements Serializable {
    @Id     @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
@ManyToOne(cascade = CascadeType.ALL)
    private SousProjet sousProjet;
  private String Titre;
  private Date  date_Debut;
  private Date Date_Fin;
    private Statut_Tache statutTache;


}
