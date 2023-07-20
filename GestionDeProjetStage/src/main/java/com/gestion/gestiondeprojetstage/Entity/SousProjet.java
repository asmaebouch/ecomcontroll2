package com.gestion.gestiondeprojetstage.Entity;

import com.gestion.gestiondeprojetstage.service.TacheService;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class SousProjet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String code;
    /*  @ManyToOne
      private Projet projet;*/
   @OneToMany
      private List<Tache> tache;
    private Date Date_Debut;
    private Date Date_Fin;
    private String Description;


    @RestController

    public static class TacheController implements Serializable {
        @Autowired
        private TacheService tacheService;

        @PostMapping("/registreTache")
        @PreAuthorize("hasRole('User')")
        public Tache registreTache(@RequestBody Tache tache){
            tache.setSousProjet(tache.getSousProjet());
            return tacheService.registreTache(tache );
        }
        @GetMapping("/getTache" )
        @PreAuthorize("hasRole('User')")

        public List<Tache> TacheList(){
            return tacheService.getTache();
        }
    }
}
