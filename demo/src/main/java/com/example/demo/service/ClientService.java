package com.example.demo.service;

import com.example.demo.dto.AgencyDTO;
import com.example.demo.dto.ClientDTO;
import com.example.demo.dto.TripDTO;
import com.example.demo.entity.Agency;
import com.example.demo.entity.Client;
import com.example.demo.entity.Trip;
import com.example.demo.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;

    public List<ClientDTO> showAllClients(){
        return ((List<Client>) clientRepository.findAll()).stream().map((client -> new ClientDTO(client.getUsername(), client.getPicture()))).toList();
    }

    public ClientDTO showAllClientsById(Long id){
        Optional<Client> client = clientRepository.findById(id);
        if(client.isPresent()){
            return new ClientDTO(client.get().getUsername(), client.get().getPicture());
        }else{
            return null;
        }
    }

    public ClientDTO addClient(Client client){
        if(clientRepository.findByUsername(client.getUsername()).isEmpty()){
            Client insertedClient = clientRepository.save(client);
            return new ClientDTO(insertedClient.getUsername(), insertedClient.getPicture());
        }
        return null;
    }

    public String deleteClientById(long id){
        Optional<Client> client = clientRepository.findById(id);
        if(client.isPresent()){
            clientRepository.deleteById(id);
            return "Client deleted";
        }else {
            return "Client not found";
        }
    }

    public ClientDTO updateClient(Client modifiedClient, String name){
        Optional<Client> oldClient = clientRepository.findByUsername(name);
        if(oldClient.isPresent()){
            Client client = oldClient.get();
            if(modifiedClient.getEmail() != null){
                client.setEmail(modifiedClient.getEmail());
            }
            if(modifiedClient.getPassword() != null){
                client.setPassword(modifiedClient.getPassword());
            }
            if(modifiedClient.getUsername() != null){
                modifiedClient.setUsername(modifiedClient.getUsername());
            }
            if(modifiedClient.getPicture() != null){
                client.setPicture(modifiedClient.getPicture());
            }

            Client newClient = clientRepository.save(client);
            return new ClientDTO(newClient.getUsername(), newClient.getPicture());
        }
        return null;
    }
}
