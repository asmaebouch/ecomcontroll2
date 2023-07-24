package com.gestion.gestiondeprojetstage.Entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;
import lombok.*;
import  com.gestion.gestiondeprojetstage.Entity.SecateursActivity;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.NotEmpty;


import java.io.Serializable;
import java.util.Date;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
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
    private String Telephone;

    //@Temporal(TemporalType.DATE)
    private Date   CreeLe;
  //  @NotEmpty(message = "Forme  cannot be empty")

    @OneToOne(cascade = CascadeType.ALL)
    private FormJuridique FormJuridique;
  //  @NotEmpty(message = "Activity sector  cannot be empty")

  @OneToOne(cascade = CascadeType.ALL)
    private SecateursActivity SecteurActivite ;
    private StatutClient statutClient;
    //collab
}
