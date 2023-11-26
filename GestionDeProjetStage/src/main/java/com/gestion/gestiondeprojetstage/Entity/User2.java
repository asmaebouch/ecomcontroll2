package com.gestion.gestiondeprojetstage.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User2 {
    @Id
    @NotEmpty(message = "Password can not b empty")

    private String userName;
    @NotEmpty(message = "Password can not b empty")

    private String userFirstName;
    @NotEmpty(message = " userLastName can not b empty")

    private String userLastName;
   @NotEmpty(message = "Password can not b empty")
    private String userPassword;
    @NotEmpty(message = "genre can not b empty")
    @Enumerated(EnumType.STRING)
    private Sexe sexe;
    @NotEmpty(message = "DateDeRecrutement can not b empty")
    @Temporal(TemporalType.DATE)
    private Date DateDeRecrutement;
    @NotEmpty(message = "DateNaissance can not b empty")
    @Temporal(TemporalType.DATE)
    private Date DateNaissance;
   // @NotEmpty(message = "Phone number  be empty")
    @Pattern(regexp = "\\d{10}", message = "Phone number must be a 10-digit number")
    private String Telephone;
    @Size(max = 50)
    @Email
    private String email;
    @NotEmpty(message = "Profil can not b empty")
    @ManyToOne()
    private Role roles ;
    @JsonIgnoreProperties("user2")
    @OneToMany
    private Collection<Projet> projets=new ArrayList<>();
    @JsonIgnoreProperties("user2List")
    @ManyToOne
    private SousProjet sousprojets;


    public User2(String username, String email, String password) {
        this.userName = username;
        this.email = email;
        this.userPassword = password;
    }


    public User2(String userName, String email, String userLastName, String userFirstName,  Date dateNaissance, String telephone, Date dateDeRecrutement, Role roles, Sexe sexe, String encode) {
   this.userName=userName;
   this.email=email;
   this.userLastName=userLastName;
   this.userFirstName=userFirstName;
   this.setDateNaissance(dateNaissance);
   this.setTelephone(telephone);
   this.setDateDeRecrutement(dateDeRecrutement);
this.roles=  roles;
this.userPassword=encode;
this.sexe=sexe;
    }
    public User2(String userName) {
        this.userName = userName;
    }

}
