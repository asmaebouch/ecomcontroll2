package com.gestion.gestiondeprojetstage.Entity;

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
  //  @NotEmpty(message = "Password can not b empty")
    private String userPassword;
   // @NotEmpty(message = "geenre can not b empty")

    @Enumerated(EnumType.STRING)

    private Sexe sexe;
    @Temporal(TemporalType.DATE)

    private Date DateDeRecrutement;
    @Temporal(TemporalType.DATE)

    private Date DateNaissance;
   // @NotEmpty(message = "Phone number  be empty")
    @Pattern(regexp = "\\d{10}", message = "Phone number must be a 10-digit number")
    private String Telephone;
    @Size(max = 50)
    @Email
    private String email;
    @ManyToOne
//Cela signifie qu'un utilisateur peut être l'administrateur
// de plusieurs autres utilisateurs,
// tandis qu'un utilisateur peut avoir un seul administrateur.
    private User2 Admin;
    @ManyToMany(fetch= FetchType.EAGER,
            cascade = CascadeType.ALL)
    @JoinTable(name="USER_ROLE",
            joinColumns = {
                    @JoinColumn(name="USER_ID")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "ROLE_ID")
            }
    )
    private Set<Role> roles ;


    public User2(String username, String email, String password) {
        this.userName = username;
        this.email = email;
        this.userPassword = password;
    }


    public User2(String userName, String email, String userLastName, String userFirstName,  Date dateNaissance, String telephone, Date dateDeRecrutement, Set<Role> roles, Sexe sexe, String encode) {
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


}
