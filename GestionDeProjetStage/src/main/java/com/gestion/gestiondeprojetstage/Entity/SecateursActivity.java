package com.gestion.gestiondeprojetstage.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "nom")) // Add this line

public class SecateursActivity  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @NotEmpty(message = "Name of the Activity sector cannot be empty")
    private String nom;
    @JsonIgnoreProperties("SecteurActivite")
    @OneToMany
    private List<Client> clients=new ArrayList<>();
    public SecateursActivity(String name) {
        this.nom = name;
    }

}
