package com.ips.produitservice.controller;

import com.ips.produitservice.entity.Produit;
import com.ips.produitservice.repository.ProduitRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProduitController {

    ProduitRepository repository;

    public ProduitController(ProduitRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/produit")
    public Produit save(@RequestBody Produit produit){
        return repository.save(produit);
    }

    @GetMapping("/produits")
    public List<Produit> findAll()
    {
        return repository.findAll();
    }

    @GetMapping("/produit/{id}")
    public Produit findById(@PathVariable("id") Long id){
        return repository.findById(id).orElseThrow(()-> new EntityNotFoundException("This product not found with the ID:: "+id));
    }


}
