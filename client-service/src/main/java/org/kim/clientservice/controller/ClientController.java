package org.kim.clientservice.controller;

import org.kim.clientservice.entity.Client;
import org.kim.clientservice.repository.ClientRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController {

    private ClientRepository repository;

    public ClientController(ClientRepository repository) {
        this.repository = repository;
    }

    // Get client by id
    @GetMapping("/clients/{id}")
    public Client getClientById(@PathVariable("id") Long id){
        return repository.findById(id).get();
    }

    @GetMapping("/clients")
    public List<Client> getAllClients(){
        return repository.findAll();
    }

    @PostMapping("/clients")
    public Client save(@RequestBody Client client){
        return repository.save(client);
    }
}
