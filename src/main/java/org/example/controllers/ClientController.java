package org.example.controllers;
import org.example.main.Clients;
import org.example.repositories.ClientsRepository;

import java.util.List;
import java.util.Scanner;

public class ClientController {
    private ClientsRepository clientsRepository;
    private Scanner scanner = new Scanner(System.in);

    public ClientController(ClientsRepository clientsRepository) {
        this.clientsRepository = clientsRepository;
    }

    public void createClient(int clientId, String fname, String lname,String bdate, String adress, String email) {
        Clients client = new Clients(clientId, fname, lname, bdate, adress, email);
        clientsRepository.save(client);
    }

    public Clients findClientById(int clientId) {
        return clientsRepository.findById(clientId);
    }

    public List<Clients> viewAllClients() {
        return clientsRepository.findAll();
    }

    public void updateClient(int clientId, String fname, String lname,String bdate, String adress, String email) {
        Clients updatedclient = new Clients(clientId, fname, lname, bdate, adress, email);
        clientsRepository.update(updatedclient);
    }

    public void deleteClient(int clientId) {
        clientsRepository.delete(clientId);
    }
}
