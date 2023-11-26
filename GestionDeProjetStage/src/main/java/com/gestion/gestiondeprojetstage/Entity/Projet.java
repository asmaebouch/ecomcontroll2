package com.gestion.gestiondeprojetstage.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "id")) // Add this line

public class Projet {
    @Id     @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @NotEmpty(message = "code  cannot be empty")

    private String code;
    @NotEmpty(message = "client  cannot be empty")
    @JsonIgnoreProperties("projets")
    @ManyToOne(fetch = FetchType.EAGER)
    private Client client;
    @NotEmpty(message = "Date_Debut  cannot be empty")
    private Date Date_Debut;
    @NotEmpty(message = "Date_Fin  cannot be empty")
    private Date Date_Fin;
    @NotEmpty(message = "statutProjet  cannot be empty")
    private StatutProjet statutProjet;
    @NotEmpty(message = "user2  cannot be empty")
    @JsonIgnoreProperties("projets")
    @ManyToOne(fetch = FetchType.EAGER)
    private User2 user2;
    @NotEmpty(message = "creeLe  cannot be empty")
    private  Date creeLe;
    @NotEmpty(message = "Budget  cannot be empty")
    private Float Budget;
    @NotEmpty(message = "user2  cannot be empty")
    @JsonIgnoreProperties("projet")
    @OneToMany
    private List<SousProjet> sousProjet;
    @Override
    public String toString() {
        return "Projet{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", statutProjet='" + statutProjet + '\'' +
                ", user2=" + user2 +
                // Add other fields here
                '}';
    }

    public Projet(String code) {
        this.code = code;
    }

}
