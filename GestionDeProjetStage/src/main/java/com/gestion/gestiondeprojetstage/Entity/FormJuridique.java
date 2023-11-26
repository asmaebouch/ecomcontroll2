package com.gestion.gestiondeprojetstage.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "nom")) // Add this line
public class FormJuridique  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @NotEmpty(message = "nom can not b empty")
    private String nom;
    @JsonIgnoreProperties("FormJuridique")
    @OneToMany
  private Collection<Client> clients=new ArrayList<>();
    public FormJuridique(String nom) {
        this.nom = nom;
    }
    @Override
    public String toString() {
        return "FormJuriduqe{" +
                "id=" + id +
                ", code='" + nom + '\''+
                ",clintes"+
                clients+
                '}';
    }


}
