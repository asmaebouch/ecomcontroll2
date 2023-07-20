package com.gestion.gestiondeprojetstage.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Profil {

    @Id
    private Long id;
    private String Code;
    private String Nom;
    private String Type;


}
