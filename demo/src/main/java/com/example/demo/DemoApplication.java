package com.example.demo;

import com.example.demo.Repository.ClientRepository;
import com.example.demo.Repository.StadeRepository;
import com.example.demo.model.Client;
import com.example.demo.model.Stade;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
    /*   .andExpect(jsonPath("$._embedded.articles[0].Nom").value("Article_1"))
                .andExpect(jsonPath("$._embedded.articles[0].Address").value("sale"))
                .andExpect(jsonPath("$._embedded.articles[0].information_contrat").value("inocontrat"))
                .andExpect(jsonPath("$._embedded.articles[0].Plan_stock").value("Planstock"))

                .andExpect(jsonPath("$._embedded.articles[0].Capacite_stock").value(10));*/
    @Bean
    public CommandLineRunner initDatabase(StadeRepository stadeRepository) {
        return (a) -> {
            var categorie1 = Stade.builder().Nom("Article_1").Address("sale").Capacite_stock(10).
                    Plan_stock("Planstock").information_contrat("inocontrat").build();
            categorie1 = stadeRepository.save(categorie1);



        };
    }
    @Bean
    public CommandLineRunner initDatabase2(ClientRepository clientRepository) {
        return (a) -> {
            var categorie1 = Client.builder().Nom("inocontrat").Address("sale").telephone(000000000).
                    Historique("Historique").build();
            categorie1 = clientRepository.save(categorie1);



        };
    }
}
