 package com.example.patientmvc.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;
//@Data pour avoir les getters et seetters geneeree un constructeur sans parametre
//AllArgs.. =>Un constructeur avec des arguments
@Data
@AllArgsConstructor @NoArgsConstructor
public class Patient {

 private Long id ;
 private String nom;
// private Date dateNaissance;
 private Act act;
 private String sexe;
 private String email;
 private String tel;
 private String prenom;
 private String cin;
 public Patient(long id, String nomdemandeur, String prenomdemandeur, String mail, String tel, String sexe, Act client,String cin) {
 this.id=id;
 this.nom=nomdemandeur;
 this.prenom=prenomdemandeur;
 this.email=mail;
 this.tel=tel;
 this.act=client;
 this.cin=cin;
 this.sexe=sexe;
 }
}
