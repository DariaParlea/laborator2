package org.example.repositories;

import org.example.model.Clients;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClientsRepository {
    private List<Clients> clients = new ArrayList<>();
    private int nextID = 1;

    public Clients findById(int clientId){
        Optional<Clients> optionalClient = clients.stream().filter(client ->client.getClient_id() == clientId).findFirst();
        return optionalClient.orElse(null);
    }

    public Clients findByEmail(String email){
        Optional<Clients> optionalClient = clients.stream().filter(client -> client.getEmail().equals(email)).findFirst();
        return optionalClient.orElse(null);
    }

    public List<Clients> findAll(){
        return clients;
    }

    public void save(Clients client){
        int index = -1;
        for(int i=0; i<clients.size(); i++)
            if(clients.get(i).getClient_id() == client.getClient_id()){
                index = i;
                break;
            }
        if(index != -1)
            clients.set(index, client);
    }

    public void delete(int clientId){
        clients.removeIf(client -> client.getClient_id() == clientId);
    }
}
