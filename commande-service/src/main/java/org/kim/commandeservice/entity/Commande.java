package org.kim.commandeservice.entity;

import jakarta.persistence.*;
import lombok.*;
import org.kim.commandeservice.model.Client;
import org.kim.commandeservice.model.Produit;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Commande {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCommande;
    private Integer quantite;
    private String adresseLivraison;

    private Long idProduit;
    @Transient
    private Produit produit;

    private Long idClient;
    @Transient
    private Client client;
}
