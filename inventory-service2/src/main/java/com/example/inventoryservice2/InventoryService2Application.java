package com.example.inventoryservice2;

import com.example.inventoryservice2.entities.Product;
import com.example.inventoryservice2.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryService2Application {

    public static void main(String[] args) {
        SpringApplication.run(InventoryService2Application.class, args);
    }
    @Bean
    CommandLineRunner start(ProductRepository bankAccountRepository){
        return  args -> {
            bankAccountRepository.save(new Product(null,"imane",9000));
            bankAccountRepository.save(new Product(null,"laila",8000));
            bankAccountRepository.save(new Product(null,"aahmdd",7000));

        };
    }
}
