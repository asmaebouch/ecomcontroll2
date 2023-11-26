package com.example.demo.service;

import com.example.demo.Repository.ClientRepository;
import com.example.demo.model.Client;
import com.example.demo.model.Stade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ClientService implements IClientService{
    @Autowired
   private ClientRepository clientRepository;
    @Override
    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client save(Client article) {
    return    clientRepository.save(article);
    }

    @Override
    public void deleteById(Long id) {
clientRepository.deleteById(id);
    }

    @Override
    public Optional<Client> findById(Long id) {
       return clientRepository.findById(id);
    }

    @Override
    public Client update(Client stade) {
        Long id = stade.getId();
        Optional<Client> optionalStade = clientRepository.findById(id);

        if (optionalStade.isPresent()) {
            Client existingStade = optionalStade.get();

            // Update the properties of the existingStade with the values from the provided stade
            existingStade.setAddress(stade.getAddress());
            existingStade.setHistorique(stade.getHistorique());
            existingStade.setNom(stade.getNom());
            existingStade.setTelephone(stade.getTelephone());
            // Save the updated Stade to the repository
            return clientRepository.save(existingStade);
        } else {
            // Stade with the given ID does not exist
            System.out.println("Client with ID " + id + " does not exist");
            return null;
        }
    }




}
