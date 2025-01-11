package com.ips.produitservice;

import com.ips.produitservice.entity.Produit;
import com.ips.produitservice.repository.ProduitRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProduitServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProduitServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ProduitRepository produitRepository){
        return args -> {
            Produit produit = Produit.builder()
                    .name("Hoodie")
                    .build();
            produitRepository.save(produit);




        };
    }

}
