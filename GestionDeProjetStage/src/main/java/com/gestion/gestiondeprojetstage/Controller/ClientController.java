package com.gestion.gestiondeprojetstage.Controller;

import com.gestion.gestiondeprojetstage.Entity.Client;
import com.gestion.gestiondeprojetstage.Repository.FormJuridiqueRpository;
import com.gestion.gestiondeprojetstage.Repository.ProjetRepository;
import com.gestion.gestiondeprojetstage.Repository.SecteurActivityRepository;
import com.gestion.gestiondeprojetstage.dao.ClientRpository;
import com.gestion.gestiondeprojetstage.service.ClientService;
import com.gestion.gestiondeprojetstage.service.JwtService;
import com.gestion.gestiondeprojetstage.service.SecteurActvity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//creer  un webservicee sans passer paar un database
//format json
@RestController

public class ClientController {
@Autowired
    private ClientRpository clientRepository;
@Autowired
private FormJuridiqueRpository  formJuridiqueRpository;
@Autowired
private ProjetRepository projetRepository;

@GetMapping(value = "/listClient/{id}")
//rien par defaut c'est json
public Client clientList(@PathVariable(name = "id") Long id){
return  clientRepository.findById(id);
}
    @PutMapping(value = "/listClient/{id}")
//rien par defaut c'est json
    public Client update(@PathVariable(name = "id") Long id,@RequestBody Client c){
       c.setId(id);
        return clientRepository.save(c);
    }
    @PostMapping(value = "/listClient")
//rien par defaut c'est json
    public Client save(@PathVariable(name = "id") Long id,@RequestBody Client c){
        c.setId(id);
        return clientRepository.save(c);
    }
    @DeleteMapping(value = "/listClient/{id}")
//rien par defaut c'est json
    public void delete(@PathVariable(name = "id") Long id){

         clientRepository.deleteById(id);
    }
    @Autowired
    private ClientService clientService;
private SecteurActvity secteurActvity;
    @Autowired
private SecteurActivityRepository secteurActivityRepository;
    @Autowired
    private JwtService jwtService;
    @PostMapping("/registreClient")
    @PreAuthorize("hasRole('Admin')")
    public Client registreClient(@RequestBody Client clients) {

        // Set the existing FormJuridique and SecteurActivite to the client

        //formJuridiqueRpository.save(existingFormJuridique);
        return clientService.registreClient(clients);
    }


    @GetMapping("/getClients")
    @PreAuthorize("hasRole('Admin')")
    public ResponseEntity<Page<Client>> getClientPage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Client> clientPage = clientService.getClients(pageable);

        //System.out.println("clients: {}"+ clientPage);

        return ResponseEntity.ok(clientPage);
    }
    @PutMapping("/updateClints")
    @PreAuthorize("hasRole('Admin')")
public Client updateClients(@RequestBody Client client){
      /*  String secteurActiviteId = client.getSecteurActivite().getNom();
        SecateursActivity optionalSecteurActivity = secteurActivityRepository.findByNom(secteurActiviteId);
        String formJuridiqueId = client.getFormJuridique().getNom();
        FormJuridique existingFormJuridique = formJuridiqueRpository.findByNom(formJuridiqueId)
                ;

        // Set the existing FormJuridique to the client
        client.setFormJuridique(existingFormJuridique);
        client.setSecteurActivite(optionalSecteurActivity);*/
     return   clientService.updateClient(client);

    }


    @DeleteMapping("/deleteClient")
    @PreAuthorize("hasRole('Admin')")
    public void deleteClient(@RequestParam Long id) {
     clientService.deleteClient(id);

    }

    @GetMapping("/ClientList")
    @PreAuthorize("hasRole('Admin')")
    public List<String> getClient() {
        List<Client> secteurs = clientService.getClients2();
        List<String> secteurNames = new ArrayList<>();

        for (Client secteur : secteurs) {
            secteurNames.add(secteur.getNom());
        }

        return secteurNames;
    }

    @GetMapping("/checkCode/{code}")
    public ResponseEntity<Boolean> checkCode(@PathVariable String code) {
        boolean isUnique = clientService.isCodeUnique(code);
        return ResponseEntity.ok(isUnique);
    }
    @GetMapping("/checkTelephone/{telephone}")
    public ResponseEntity<Boolean> checkTelephone(@PathVariable String Telephone) {
        boolean isUnique = clientService.isTelephoneUnique(Telephone);
        return ResponseEntity.ok(isUnique);
    }



}
