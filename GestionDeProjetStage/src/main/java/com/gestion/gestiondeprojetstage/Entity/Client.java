package com.gestion.gestiondeprojetstage.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "id")) // Add this line to ensure id is unique


public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Name  cannot be empty")
    private String nom;
    @NotEmpty(message = "Code number cannot be empty")
    private String code;
    @NotEmpty(message = "Phone number  be empty")
   // @Pattern(regexp = "\\d{10}", message = "Phone number must be a 10-digit number")
    private String telephone;
    @JsonIgnoreProperties("clients")

    @ManyToOne(fetch = FetchType.EAGER,optional = true)
    private FormJuridique FormJuridique;
    @NotEmpty(message = "Date  cannot be empty")
    //@Temporal(TemporalType.DATE)
    private Date   CreeLe;
    @NotEmpty(message = "statutClient  cannot be empty")
    private StatutClient statutClient;
    @JsonIgnoreProperties("client")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private Collection<Projet> projets=new ArrayList<>();

    @JsonIgnoreProperties("clients")
    @ManyToOne(fetch = FetchType.EAGER,optional = true)
    private SecateursActivity SecteurActivite ;
    //collab
    public Client(String name) {
        this.nom = name;
    }
    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", code='" + code + '\'' +
                ", Telephone='" + telephone + '\'' +
                ", CreeLe=" + CreeLe +
                ", FormJuridique=" + (FormJuridique != null ? FormJuridique.getNom() : "null") + // Access FormJuridique's properties
                ", SecteurActivite=" + (SecteurActivite != null ? SecteurActivite.getNom() : "null") + // Access SecteurActivite's properties
                ", statutClient=" + statutClient +
                ",projeet="+projets+
                // Avoid accessing projets collection here
                '}';
    }

}
