package com.thehecklers.sburrestdemo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thehecklers.sburrestdemo.model.Client;

@RestController
@RequestMapping("/clients")
public class ClienteController
{
	private List<Client> clients = new ArrayList<>();

	public ClienteController() {
		clients.addAll(List.of(
				new Client("Du"),
				new Client("Dudu"),
				new Client("Edu")
		));
	}

	@GetMapping
	Iterable<Client> getCoffees() {
		return clients;
	}

    @PostMapping
    Client addClient(@RequestBody String name)
    {
        Client client = new Client(name);
        return client;
    }

    @PutMapping
    Client editClient(@PathVariable String id, @RequestBody String name)
    {
        clients
    }
}