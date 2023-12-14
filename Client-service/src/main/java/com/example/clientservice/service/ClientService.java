package com.example.clientservice.service;

import com.example.clientservice.Dao.ClientDao;
import com.example.clientservice.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService implements IClientService{
    @Autowired
    private ClientDao clientDao;

    @Override
    public List<Client> getAll() {
        return clientDao.findAll();
    }

    @Override
    public Client save(Client article) {
        return clientDao.save(article);
    }

    @Override
    public void deleteById(Long id) {
        clientDao.deleteById(id);
    }

    @Override
    public Optional<Client> findById(Long id) {
        return clientDao.findById(id);
    }

    @Override
    public Client update(Client stade) {
        Long id = stade.getId();
        Optional<Client> optionalStade = clientDao.findById(id);

        if (optionalStade.isPresent()) {
            Client existingStade = optionalStade.get();
            existingStade.setName(stade.getName());
            existingStade.setEmail(stade.getEmail());

            return clientDao.save(existingStade);
        } else {
            // Stade with the given ID does not exist
            System.out.println("Client with ID " + id + " does not exist");
            return null;
        }
    }
}
