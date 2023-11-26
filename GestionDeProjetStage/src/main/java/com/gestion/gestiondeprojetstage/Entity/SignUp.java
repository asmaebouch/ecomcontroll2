package com.gestion.gestiondeprojetstage.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignUp {

    private String userName;

    private String userFirstName;

    private String userLastName;
    //  @NotEmpty(message = "Password can not b empty")
    private String userPassword;
    // @NotEmpty(message = "geenre can not b empty")


    private Sexe sexe;

    private Date DateDeRecrutement;

    private Date DateNaissance;
    // @NotEmpty(message = "Phone number  be empty")
    private String Telephone;

    private String email;
//Cela signifie qu'un utilisateur peut être l'administrateur
// de plusieurs autres utilisateurs,
// tandis qu'un utilisateur peut avoir un seul administrateur.
    private User2 Admin;

    private Role roles;


}
