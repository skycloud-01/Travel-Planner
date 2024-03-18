package com.example.demo.controller;

import com.example.demo.dto.ClientDTO;
import com.example.demo.dto.TripDTO;
import com.example.demo.entity.Client;
import com.example.demo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {
    @Autowired
    ClientService clientService;

    @GetMapping("/getAll")
    @ResponseBody
    public List<ClientDTO> getAllClients(){return clientService.showAllClients();}

    @GetMapping("/getById/{id}")
    @ResponseBody
    public ClientDTO getClientsById(@PathVariable Long id) {return clientService.showAllClientsById(id);}

    @DeleteMapping("/deleteById/{id}")
    @ResponseBody
    public String deleteClientById(@PathVariable Long id) {
        return clientService.deleteClientById(id);
    }

    @PutMapping("/updateClient/{name}")
    @ResponseBody
    public ClientDTO updateClient(@RequestBody Client client, @PathVariable String name){ return clientService.updateClient(client, name);}

    @PostMapping("/addClient")
    @ResponseBody
    public ClientDTO addClient(@RequestBody Client client) { return clientService.addClient(client);}
}
