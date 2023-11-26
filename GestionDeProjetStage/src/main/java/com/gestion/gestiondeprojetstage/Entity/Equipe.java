package com.gestion.gestiondeprojetstage.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Equipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @JsonIgnoreProperties("sousprojets")
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
  private List<User2> user2List;
    @OneToOne
    private SousProjet sousProjet;
   /* @OneToOne
    private Role2 role2;*/

}
