/*package pfe.example.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pfe.example.DAO.ClientRep;
import pfe.example.Entities.Client;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRep clientRepository;

    @Override
    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client getClientByCin(String cin) {
        return clientRepository.findById(cin).orElse(null);
    }

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client updateClient(String cin, Client updatedClient) {
        Optional<Client> existingClient = clientRepository.findById(cin);
        if (existingClient.isPresent()) {
            Client client = existingClient.get();
            client.setNom_clt(updatedClient.getNom_clt());
            client.setPrenom_clt(updatedClient.getPrenom_clt());
            client.setClt_adress(updatedClient.getClt_adress());
            client.setPhone_number(updatedClient.getPhone_number());
            return clientRepository.save(client);
        }
        return null;
    }

    @Override
    public boolean deleteClient(String cin) {
        if (clientRepository.existsById(cin)) {
            clientRepository.deleteById(cin);
            return true;
        }
        return false;
    }
}
*/