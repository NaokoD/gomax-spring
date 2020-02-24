package com.gomax.controllers;

import com.gomax.entities.Client;
import com.gomax.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        return new ResponseEntity<>(this.clientService.findAllClients(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable Long id){
        return new ResponseEntity<>(this.clientService.findClientById(id).get(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Client> postClient(@RequestBody Client client){
        return new ResponseEntity<>(this.clientService.saveClient(client), HttpStatus.CREATED);
    }

    @PutMapping("")
    public ResponseEntity<Client> putClient(@RequestBody Client client){
        return  new ResponseEntity<>(this.clientService.saveClient(client), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteClientById(@PathVariable Long id){
        return new ResponseEntity<>(this.clientService.deleteClientById(id), HttpStatus.OK);
    }

}
