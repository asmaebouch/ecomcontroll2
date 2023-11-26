package com.gestion.gestiondeprojetstage.service;

import com.gestion.gestiondeprojetstage.Entity.Client;
import com.gestion.gestiondeprojetstage.Entity.Projet;
import com.gestion.gestiondeprojetstage.Repository.ProjetRepository;
import com.gestion.gestiondeprojetstage.dao.ClientRpository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ProjetService {
    @Autowired
    private ProjetRepository projetRepository;
    @Autowired
    private ClientRpository clientRpository;
    public Projet registreProjet(Projet projet) {
        String clientNom = projet.getClient().getNom();

        Client existingClient = clientRpository.findByNom(clientNom);
        System.out.println(existingClient.getNom());

        if (existingClient != null) {
            projet.setClient(existingClient);
            System.out.println(projet.getClient());

            // Save the projet first
            Projet savedProjet = projetRepository.save(projet);

            existingClient.getProjets().add(savedProjet);
            // Now save the updated client with the new projet
            clientRpository.save(existingClient);

            return savedProjet;
        } else {
            System.out.println("Client not found. Cannot save Projet.");
            return null; // Or handle the error appropriately
        }
    }


    public List<Projet> getProjet()
    {
        return (List<Projet>) projetRepository.findAll();
    }
    @Transactional
    public void deleteProjet(Long id) throws Exception {
        // Step 1: Retrieve the project to be deleted
        Projet projetToDelete = projetRepository.findById(id);
        if (projetToDelete == null) {
            throw new Exception("Project with id " + id + " not found");
        }

        // Step 2: Remove the project from the client's list of projects
        Client client = projetToDelete.getClient();
        if (client != null) {
            client.getProjets().remove(projetToDelete);
        }

        // Step 3: Save the client back to the database (this will also cascade the removal of the project)
        clientRpository.save(client);
    }
    public Projet updateProjet(Projet client){
        Long id = client.getId();
        client.getId();
        Projet client1 = projetRepository.findById(id);
        if (client1 == null) {
            System.out.println("eerrrorrr projet no found");
        }
        if (client1 != null) {
            client1.setCode(client.getCode());
            client1.setClient(client.getClient());
            client1.setDate_Debut(client.getDate_Debut());
            client1.setDate_Fin(client.getDate_Fin());
            client1.setStatutProjet(client.getStatutProjet());
            client1.setCreeLe(client.getCreeLe());
            client1.setBudget(client.getBudget());

            client1.setUser2(client.getUser2());

            return projetRepository.save(client1);
        }
        return null; // Handle the case where client1 is null
    }
    public List<Projet> getProjet2()
    {
        return (List<Projet>) projetRepository.findAll();
    }
}
