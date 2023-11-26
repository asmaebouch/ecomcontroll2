package com.gestion.gestiondeprojetstage.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class SousProjet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String code;
    /*  @ManyToOne
      private Projet projet;*/
    @JsonIgnoreProperties("sousProjet")
   @OneToMany
      private List<Tache> tache;

    @JsonIgnoreProperties("sousProjet")
    @ManyToOne
    private Projet projet;
    private Date Date_Debut;
    private Date Date_Fin;
    private String Description;
    public SousProjet(String code) {
        this.code = code;
    }



}
