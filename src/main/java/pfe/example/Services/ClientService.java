package pfe.example.Services;

import java.util.List;
import pfe.example.Entities.Client;

public interface ClientService {
    Client createClient(Client client);
    Client getClientByCin(String cin);
    List<Client> getAllClients();
    Client updateClient(String cin, Client updatedClient);
    boolean deleteClient(String cin);
} 
