package com.gestion.gestiondeprojetstage.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Tache  {
    @Id     @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @JsonIgnoreProperties("tache")
    @ManyToOne(fetch = FetchType.EAGER,optional = true)
    private SousProjet sousProjet;
  private String Titre;
  private Date  date_Debut;
  private Date Date_Fin;
    private Statut_Tache statutTache;


}
