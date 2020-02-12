package com.gomax.controllers;

import com.gomax.entities.Client;
import com.gomax.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private ClientService clientService;

    @Autowired
    ClientController(ClientService clientService){
        this.clientService = clientService;
    }

    @GetMapping("")
    public ResponseEntity<List<Client>> getAllClients(){
        return new ResponseEntity<List<Client>>(this.clientService.findAllClients(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable Long id){
        return new ResponseEntity<Client>(this.clientService.findClientById(id).get(), HttpStatus.OK);
    }

}
