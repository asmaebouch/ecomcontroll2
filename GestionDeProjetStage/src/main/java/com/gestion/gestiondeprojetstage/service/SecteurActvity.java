package com.gestion.gestiondeprojetstage.service;

import com.gestion.gestiondeprojetstage.Entity.Client;
import com.gestion.gestiondeprojetstage.Entity.SecateursActivity;
import com.gestion.gestiondeprojetstage.Repository.SecteurActivityRepository;
import com.gestion.gestiondeprojetstage.dao.ClientRpository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service

public class SecteurActvity {
    @Autowired
    private SecteurActivityRepository secteurActivityRepository;
    @Autowired

    private ClientRpository clientRepository;
    public SecateursActivity registreSecteur(SecateursActivity secateursActivity){
        return secteurActivityRepository.save(secateursActivity);
    }
    public List<SecateursActivity> getSecteurs(){
        return secteurActivityRepository.findAll();
    }

    public void deleteSecteur(Long id){
        // Find the FormJuridique entity by ID
        SecateursActivity formJuridique = secteurActivityRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("FormJuridique not found"));

        Collection<Client> clients = formJuridique.getClients();
        String formJuridiqueId = null;

        for (Client client : clients) {
            client.setSecteurActivite(null);
            if (client.getFormJuridique() != null) {
                formJuridiqueId = client.getSecteurActivite().getNom();
            }
            clientRepository.save(client);
        }
        System.out.println(clients);
        System.out.println("rrrrrrrrrrrrrrrr22");

        secteurActivityRepository.deleteById(formJuridique.getId());
    }
}
