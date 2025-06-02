package pfe.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import pfe.example.Entities.Client;
import pfe.example.Services.ClientService;

@RestController
@RequestMapping("/api/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    // Créer un client
    @PostMapping("/create")
    public ResponseEntity<Client> createClient(@RequestBody Client client) {
        Client created = clientService.createClient(client);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    //  Obtenir un client par CIN
    @GetMapping("/{cin}")
    public ResponseEntity<Client> getClientByCin(@PathVariable String cin) {
        Client client = clientService.getClientByCin(cin);
        if (client != null) {
            return ResponseEntity.ok(client);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //  Obtenir tous les clients
    @GetMapping("/all")
    public ResponseEntity<List<Client>> getAllClients() {
        List<Client> clients = clientService.getAllClients();
        return ResponseEntity.ok(clients);
    }

    //  Mettre à jour un client
    @PutMapping("/update/{cin}")
    public ResponseEntity<Client> updateClient(@PathVariable String cin, @RequestBody Client updatedClient) {
        Client updated = clientService.updateClient(cin, updatedClient);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Supprimer un client
    @DeleteMapping("/delete/{cin}")
    public ResponseEntity<Void> deleteClient(@PathVariable String cin) {
        boolean deleted = clientService.deleteClient(cin);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}