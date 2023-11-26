package com.gestion.gestiondeprojetstage;

import com.gestion.gestiondeprojetstage.Entity.Client;
import com.gestion.gestiondeprojetstage.dao.ClientRpository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication

public class GestionDeProjetStageApplication implements CommandLineRunner {
@Autowired
private ClientRpository clientRepository;
@Autowired
private RepositoryRestConfiguration restConfiguration;





    public static void main(String[] args) {
        SpringApplication.run(GestionDeProjetStageApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
       restConfiguration.exposeIdsFor(Client.class);
     //   clientRepository.save(new Client(null,"asmae","sdvs", StatutClient.ACTIF));
       // clientRepository.save(new Client(null,"ilham","dsdfs", StatutClient.ACTIF));
        //clientRepository.save(new Client(null,"noor","rrr", StatutClient.ACTIF));
clientRepository.findAll().forEach(p->{
    System.out.println(p.toString());
});
    }
}
