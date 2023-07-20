package com.gestion.gestiondeprojetstage.Controller;

import com.gestion.gestiondeprojetstage.Entity.Client;
import com.gestion.gestiondeprojetstage.Entity.SecateursActivity;
import com.gestion.gestiondeprojetstage.Repository.ClientRepository;
import com.gestion.gestiondeprojetstage.Repository.SecteurActivityRepository;
import com.gestion.gestiondeprojetstage.service.ClientService;
import com.gestion.gestiondeprojetstage.service.JwtService;
import com.gestion.gestiondeprojetstage.service.SecteurActvity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.Collections;
import java.util.List;

//creer  un webservicee sans passer paar un database
//format json
@RestController

public class ClientController {
@Autowired
    private ClientRepository clientRepository;
@GetMapping(value = "/listClient/{id}")
//rien par defaut c'est json
public Client clientList(@PathVariable(name = "id") Long id){
return  clientRepository.findById(id).get();
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
    @Qualifier("secteurActivityRepository")
private SecteurActivityRepository secteurActivityRepository;
    @Autowired
    private JwtService jwtService;
    @PostMapping("/registreClient")
    @PreAuthorize("hasRole('Admin')")
    public Client registreClient(@RequestBody Client clients){
     //   SecateursActivity secteurActivite = secteurActivityRepository.save(clients.getSecteurActivite());
       // secteurActivityRepository.save(secteurActivite);

        clients.setSecteurActivite(clients.getSecteurActivite());

        return clientService.registreClient(clients);
              }
    @GetMapping("/getClients")
    @PreAuthorize("hasRole('Admin')")

    public List<Client> clientList(){
        return clientService.getClients() ;
    }
}
