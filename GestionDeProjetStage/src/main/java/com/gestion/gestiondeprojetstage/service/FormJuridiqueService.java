package com.gestion.gestiondeprojetstage.service;

import com.gestion.gestiondeprojetstage.Entity.Client;
import com.gestion.gestiondeprojetstage.Entity.FormJuridique;
import com.gestion.gestiondeprojetstage.Repository.FormJuridiqueRpository;
import com.gestion.gestiondeprojetstage.dao.ClientRpository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service

public class FormJuridiqueService {
    @Autowired
    private FormJuridiqueRpository formJuridiqueRpository;
    @Autowired

    private ClientRpository clientRepository;
    @Autowired
    private ClientService clientService;
    public FormJuridique registreForm(FormJuridique secateursActivity){
        return formJuridiqueRpository.save(secateursActivity);
    }

    public Page getForm(Pageable pageable){
        return formJuridiqueRpository.findAll( pageable);
    }
    public List<FormJuridique> getForm2(){
        return  formJuridiqueRpository.findAll();
    }

    public void deleteForme(Long id) {
        // Find the FormJuridique entity by ID
        FormJuridique formJuridique = formJuridiqueRpository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("FormJuridique not found"));

        Collection<Client> clients = formJuridique.getClients();
        String formJuridiqueId = null;

        for (Client client : clients) {
            client.setFormJuridique(null);
            if (client.getFormJuridique() != null) {
                formJuridiqueId = client.getFormJuridique().getNom();
            }
            clientRepository.save(client);
        }
        System.out.println(clients);
        System.out.println("rrrrrrrrrrrrrrrr22");

        formJuridiqueRpository.deleteById(formJuridique.getId());
    }


    public FormJuridique updateFormJurridique(FormJuridique client){
        String id = client.getNom();
        FormJuridique client1 = formJuridiqueRpository.findByNom(id);

        if (client1 == null) {
            System.out.println("eerrrorrr client no found");
        }

        // Update client properties if client1 is not null
        if (client1 != null) {
            client1.setNom(client.getNom());
            return formJuridiqueRpository.save(client1);
        }

        return null;
    }


    }

