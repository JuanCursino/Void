package com.thehecklers.sburrestdemo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.thehecklers.sburrestdemo.model.Client;

@Service
public class ClientService
{
    private List<Client> clients = new ArrayList<>();

	public ClientService() {
		clients.addAll(List.of(
				new Client("Du"),
				new Client("Dudu"),
				new Client("Edu")
		));
	}

    public List<Client> getAllClients()
    {
        return clients;
    }

    public Client getClientById(String id)
    {
        for (Client client : clients)
            if (client.getId().equals(id))
                return client;

        return null;
    }

    public Client addClient(Client client)
    {
        clients.add(client);

        return client;
    }

    public Client editClient(String id, Client editedClient)
    {
        Client client = getClientById(id);

        if (client != null)
            client.setName(editedClient.getName());
                
        return client;
    }

    public Boolean deleteClient(String id)
    {
        Client client = getClientById(id);

        if (client != null)
        {
            clients.remove(client);
            return true;
        }

        return false;
    }
    
}