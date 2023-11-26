package com.gestion.gestiondeprojetstage.Controller;

import com.gestion.gestiondeprojetstage.Entity.Client;
import com.gestion.gestiondeprojetstage.Entity.FormJuridique;
import com.gestion.gestiondeprojetstage.Entity.FormWithClientsDTO;
import com.gestion.gestiondeprojetstage.Repository.FormJuridiqueRpository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
@RestController
public class FormWithClientsDTOController {
    @Autowired
    FormJuridiqueRpository formJuridiqueRpository;
    @GetMapping("/formsWithClients")
    public ResponseEntity<List<FormWithClientsDTO>> getFormsWithClients() {
        List<FormWithClientsDTO> formWithClientsList = new ArrayList<>();

        List<FormJuridique> formJuridiques = formJuridiqueRpository.findAll(); // Assuming you have a repository for FormJuridique

        for (FormJuridique formJuridique : formJuridiques) {
            List<Client> clientDTOs = new ArrayList<>();
            for (Client client : formJuridique.getClients()) {
                Client clientDTO = new Client();
                clientDTOs.add(clientDTO);
            }

            FormWithClientsDTO formWithClientsDTO = new FormWithClientsDTO(formJuridique.getNom(), clientDTOs);
            formWithClientsList.add(formWithClientsDTO);
        }
        System.out.println(formJuridiques);

        return ResponseEntity.ok(formWithClientsList);
    }




}
