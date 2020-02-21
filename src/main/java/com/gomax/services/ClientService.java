package com.gomax.services;

import com.gomax.entities.Client;
import com.gomax.repositories.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private ClientRepository clientRepository;

    ClientService(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    public List<Client> findAllClients(){
        return (List<Client>) this.clientRepository.findAll();
    }

    public Optional<Client> findClientById(Long id){
        return this.clientRepository.findById(id);
    }

    public Client saveClient(Client client){
        return this.clientRepository.save(client);
    }

    public Boolean deleteClientById(Long id){
        this.clientRepository.deleteById(id);
        return  this.clientRepository.existsById(id);
    }
}
