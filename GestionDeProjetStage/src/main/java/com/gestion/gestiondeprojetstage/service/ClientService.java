package com.gestion.gestiondeprojetstage.service;

import com.gestion.gestiondeprojetstage.Entity.Client;
import com.gestion.gestiondeprojetstage.Entity.FormJuridique;
import com.gestion.gestiondeprojetstage.Entity.SecateursActivity;
import com.gestion.gestiondeprojetstage.Repository.FormJuridiqueRpository;
import com.gestion.gestiondeprojetstage.Repository.SecteurActivityRepository;
import com.gestion.gestiondeprojetstage.dao.ClientRpository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ClientService {
    @Autowired
    private ClientRpository clientRpository;
    @Autowired
    private FormJuridiqueRpository formJuridiqueRpository;
    @Autowired
    private SecteurActivityRepository secteurActivityRepository;
      public Client registreClient(Client client){
       /*   SecateursActivity secteurActivite = client.getSecteurActivite();
          if (secteurActivite != null && secteurActivite.getId() == null) {
              secteurActivite = secteurActivityRepository.save(secteurActivite);
          }
          client.setSecteurActivite(secteurActivite);
          FormJuridique formJuridique = client.getFormJuridique();
          if (formJuridique != null && formJuridique.getId() == null) {
              formJuridique = formJuridiqueRpository.save(formJuridique);
          }
          client.setFormJuridique(formJuridique);*/
        return clientRpository.save(client);
    }
    public List<Client> getClients()
    {
        return (List<Client>) clientRpository.findAll();
    }
    public void deleteClient(Integer id)
    {
         clientRpository.deleteById(id);
    }


}
