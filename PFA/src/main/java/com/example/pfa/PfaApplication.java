package com.example.pfa;

import com.example.pfa.Dao.IFicheDeRecherche;
import com.example.pfa.Dao.IPoliceT;
import com.example.pfa.Model.FicheDeRecherche;
import com.example.pfa.Model.PoliceT;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PfaApplication {

    public static void main(String[] args) {
        SpringApplication.run(PfaApplication.class, args);
    }
    @Bean
    CommandLineRunner start(IPoliceT clientDao){
        return args -> {

            clientDao.save(new PoliceT(null,"asme","bouchekeara","AAE234","asmae.bouchekaraa@gmail.com","Asmae123"));
            clientDao.save(new PoliceT(null,"asme2","bouchekeara2","AAE2343","asmae.bouchekaraa4@gmail.com","Asmae1234"));
            clientDao.save(new PoliceT(null,"asme3","bouchekeara3","AAE2345","asmae.bouchekaraa6@gmail.com","Asmae1235"));

        };
    }
}
