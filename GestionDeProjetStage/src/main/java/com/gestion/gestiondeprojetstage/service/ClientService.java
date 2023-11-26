package com.gestion.gestiondeprojetstage.service;

import com.gestion.gestiondeprojetstage.Entity.Client;
import com.gestion.gestiondeprojetstage.Entity.FormJuridique;
import com.gestion.gestiondeprojetstage.Entity.SecateursActivity;
import com.gestion.gestiondeprojetstage.Repository.FormJuridiqueRpository;
import com.gestion.gestiondeprojetstage.Repository.SecteurActivityRepository;
import com.gestion.gestiondeprojetstage.dao.ClientRpository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

      public Client registreClient(Client clients){
          String secteurActiviteId = null;
          String formJuridiqueId = null;

          if (clients.getSecteurActivite() != null) {
              secteurActiviteId = clients.getSecteurActivite().getNom();
          }

          if (clients.getFormJuridique() != null) {
              formJuridiqueId = clients.getFormJuridique().getNom();
          }
          SecateursActivity optionalSecteurActivity = null;
          FormJuridique existingFormJuridique = null;
          if (secteurActiviteId != null) {
              optionalSecteurActivity = secteurActivityRepository.findByNom(secteurActiviteId);
              clients.setSecteurActivite(optionalSecteurActivity);
              optionalSecteurActivity.getClients().add(clients);
          }
          if (formJuridiqueId != null) {
              existingFormJuridique = formJuridiqueRpository.findByNom(formJuridiqueId);
              clients.setFormJuridique(existingFormJuridique);
              System.out.println("ffffffffffffffffffff");
              existingFormJuridique.getClients().add(clients);

          }

        else {
              clientRpository.save(clients);
          }
          clientRpository.save(clients);

          System.out.println("bbb");
          return  clients;
    }

    public Page getClients(Pageable pageable)
    {
        return  clientRpository.findAll(pageable);
    }
    public List<Client> getClients2()
    {
        return (List<Client>) clientRpository.findAll();
    }
    @Transactional

    public void deleteClient(Long id) {
        Client client = clientRpository.findById(id);

        if (client != null) {
            // Detach the FormJuridique entity
            FormJuridique formJuridique = client.getFormJuridique();
            if (formJuridique != null) {
                formJuridique.getClients().remove(client);
            }
            SecateursActivity secateursActivity = client.getSecteurActivite();
            if (secateursActivity != null) {
                secateursActivity.getClients().remove(client);
            }
            // Delete the client
            clientRpository.delete(client);
        }
    }
  /*  public Client updateClient(Client client) {
        Long id = client.getId();
        Client client1 = clientRpository.findById(id);
        if (client1 == null) {
            System.out.println("Error: Client not found");
            return null; // Handle the case where the client is not found
        }

        // Save the FormJuridique and SecteurActivite entities if necessary
        String secteurActiviteId = null;
        String formJuridiqueId = null;

        if (client.getSecteurActivite() != null) {
            secteurActiviteId = client.getSecteurActivite().getNom();
        }

        if (client.getFormJuridique() != null) {
            formJuridiqueId = client.getFormJuridique().getNom();
        }

        SecateursActivity optionalSecteurActivity = null;
        FormJuridique existingFormJuridique = null;

        if (secteurActiviteId != null) {
            optionalSecteurActivity = secteurActivityRepository.findByNom(secteurActiviteId);
          //  client1.setSecteurActivite(optionalSecteurActivity);
           // optionalSecteurActivity.getClients().add(client1);
            if (optionalSecteurActivity == null) {
                System.out.println("Error: SecteurActivite not found");
            }

            // Save the SecteurActivite entity
            secteurActivityRepository.save(optionalSecteurActivity);

            client1.setSecteurActivite(optionalSecteurActivity);
        }

        if (formJuridiqueId != null) {
            existingFormJuridique = formJuridiqueRpository.findByNom(formJuridiqueId);
          //  clients.setFormJuridique(existingFormJuridique);
           // System.out.println("ffffffffffffffffffff");
           // existingFormJuridique.getClients().add(clients);
            if (existingFormJuridique == null) {
                System.out.println("Error: FormJuridique not found");

            }

            // Save the FormJuridique entity
            formJuridiqueRpository.save(existingFormJuridique);

            client1.setFormJuridique(existingFormJuridique);
        }

        // Set other properties of the client
        client1.setNom(client.getNom());
        client1.setCode(client.getCode());
        client1.setTelephone(client.getTelephone());
        client1.setCreeLe(client.getCreeLe());
        client1.setStatutClient(client.getStatutClient());

        // Save the Client entity
        return clientRpository.save(client1);
    }*/
  public Client updateClient(Client client) {
      Long id = client.getId();
      Client client1 = clientRpository.findById(id);

      if (client1 == null) {
          System.out.println("Error: Client not found");
          return null; // Handle the case where the client is not found
      }

      String secteurActiviteId = null;
      String formJuridiqueId = null;

      // Check if the FormJuridique association is changing
      if (client1.getFormJuridique() != null) {
          formJuridiqueId = client.getFormJuridique() != null ? client.getFormJuridique().getNom() : null;
      } else {
          // The client's current FormJuridique is null, so set the formJuridiqueId accordingly
          formJuridiqueId = (client.getFormJuridique() != null) ? client.getFormJuridique().getNom() : null;
      }

      SecateursActivity optionalSecteurActivity = null;
      FormJuridique existingFormJuridique = null;

      // Save SecteurActivite if it's not null
      if (client.getSecteurActivite() != null) {
          secteurActiviteId = client.getSecteurActivite().getNom();
      }

      if (secteurActiviteId != null) {
          optionalSecteurActivity = secteurActivityRepository.findByNom(secteurActiviteId);
          // Remove the client from the old FormJuridique's list of clients
          if (client1.getSecteurActivite() != null) {
              client1.getSecteurActivite().getClients().remove(client1);
          }
          if (optionalSecteurActivity != null) {
              client1.setSecteurActivite(optionalSecteurActivity);
              optionalSecteurActivity.getClients().add(client1);
          }
      }else {
              client1.setSecteurActivite(null);
          }

      if (formJuridiqueId != null) {
          existingFormJuridique = formJuridiqueRpository.findByNom(formJuridiqueId);

          // Remove the client from the old FormJuridique's list of clients
          if (client1.getFormJuridique() != null) {
              client1.getFormJuridique().getClients().remove(client1);
          }
          if (existingFormJuridique != null) {
              client1.setFormJuridique(existingFormJuridique);
              existingFormJuridique.getClients().add(client1);
          }

      } else {
          client1.setFormJuridique(null);
      }

      // Set other properties of the client
      client1.setNom(client.getNom());
      client1.setCode(client.getCode());
      client1.setTelephone(client.getTelephone());
      client1.setCreeLe(client.getCreeLe());
      client1.setStatutClient(client.getStatutClient());

      // Save the Client entity
      return clientRpository.save(client1);
  }


    public boolean isCodeUnique(String code) {
        // Implement logic to check if the code exists in the database
        return !clientRpository.existsByCode(code);
    }
    public boolean isTelephoneUnique(String Telephone) {
        // Implement logic to check if the code exists in the database
        return !clientRpository.existsByTelephone(Telephone);
    }

}
