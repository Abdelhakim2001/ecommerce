package com.ips.produitservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Produit {



    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduit;
    private String name;



}
