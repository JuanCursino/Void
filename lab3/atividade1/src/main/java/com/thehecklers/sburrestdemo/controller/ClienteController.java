package com.thehecklers.sburrestdemo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thehecklers.sburrestdemo.service.ClientService;

import com.thehecklers.sburrestdemo.model.Client;


@RestController
@RequestMapping("/clients")
public class ClienteController
{
    @Autowired
    private ClientService clientService;

	@GetMapping
	Iterable<Client> getAllClients() {
		return clientService.getAllClients();
	}

    @GetMapping("/{id}")
    Client getClientById(@PathVariable String id)
    {
        return clientService.getClientById(id);
    }

    @PostMapping
    Client addClient(@RequestBody Client client)
    {
        return clientService.addClient(client);
    }

    @PutMapping("/{id}")
    Client editClient(@PathVariable String id, @RequestBody Client client)
    {
        return clientService.editClient(id, client);
    }

    @DeleteMapping("{id}")
    Boolean deleteClient(@PathVariable String id)
    {
        return clientService.deleteClient(id);
    }
}