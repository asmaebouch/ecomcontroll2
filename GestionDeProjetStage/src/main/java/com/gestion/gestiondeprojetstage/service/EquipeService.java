package com.gestion.gestiondeprojetstage.service;

import com.gestion.gestiondeprojetstage.Entity.Equipe;
import com.gestion.gestiondeprojetstage.Entity.SousProjet;
import com.gestion.gestiondeprojetstage.Entity.User2;
import com.gestion.gestiondeprojetstage.Repository.EquipeRepository;
import com.gestion.gestiondeprojetstage.Repository.SousProjetRepository;
import com.gestion.gestiondeprojetstage.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class EquipeService {
    @Autowired
    EquipeRepository equipeRepository;
    @Autowired
    SousProjetRepository sousProjetRepository;
    @Autowired
    UserDao userDao;
    public Equipe registreEquipe(Equipe equipe) {
        String secteurActiviteId = null;
        String formJuridiqueId = null;

        if (equipe.getSousProjet() != null) {
            secteurActiviteId = equipe.getSousProjet().getCode();
        }
        SousProjet optionalSecteurActivity = null;
        if (secteurActiviteId != null) {
            optionalSecteurActivity = sousProjetRepository.findByCode(secteurActiviteId);
            equipe.setSousProjet(optionalSecteurActivity);
           // optionalSecteurActivity.getProjet().add(clients);
        }

        List<User2> user2List = equipe.getUser2List();
        List<User2> usersToAdd = new ArrayList<>();

        if (user2List != null && !user2List.isEmpty()) {
            for (User2 user : user2List) {
                // Assurez-vous que l'utilisateur existe déjà dans la base de données
                User2 existingUser = userDao.findByUserName(user.getUserName());

                if (existingUser != null) {
                    // L'utilisateur existe, ajoutez-le à la liste temporaire
                    usersToAdd.add(existingUser);
                }
            }
        }

// Ajoutez les utilisateurs de la liste temporaire à l'équipe
        equipe.setUser2List(usersToAdd);
        return equipeRepository.save(equipe);
    }

    public List<Equipe> getEquipe()
    {
        return (List<Equipe>) equipeRepository.findAll();
    }


}
