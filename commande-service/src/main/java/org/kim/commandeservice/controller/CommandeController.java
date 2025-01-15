package org.kim.commandeservice.controller;

import lombok.AllArgsConstructor;
import org.kim.commandeservice.entity.Commande;
import org.kim.commandeservice.feign.ClientRestClient;
import org.kim.commandeservice.feign.ProduitRestClient;
import org.kim.commandeservice.model.Client;
import org.kim.commandeservice.model.Produit;
import org.kim.commandeservice.repository.CommandeRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class CommandeController {

    private CommandeRepository repository;
    private ClientRestClient clientRestClient;
    private ProduitRestClient produitRestClient;



    @GetMapping("/commandes")
    public List<Commande> findAll(){

        List<Commande> commandes = repository.findAll();


        for(Commande c : commandes){

            Client client = clientRestClient.getClient(c.getIdClient());
            c.setClient(client);
            Produit produit = produitRestClient.getProduit(c.getIdProduit());
            c.setProduit(produit);
        }

        return commandes;
    }

    @GetMapping("/commandes/{id}")
    public Commande findById(@PathVariable Long id){
        Commande commande = repository.findById(id).get();

        Client client = clientRestClient.getClient(commande.getIdClient());
        commande.setClient(client);

        Produit produit = produitRestClient.getProduit(commande.getIdProduit());
        commande.setProduit(produit);
        return commande;
    }


    @PostMapping("/commandes")
    public Commande save(Commande commande){
        return repository.save(commande);
    }
}
