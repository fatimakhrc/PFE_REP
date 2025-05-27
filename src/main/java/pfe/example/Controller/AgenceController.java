package pfe.example.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import pfe.example.DTO.AgenceDetailsDto;
import pfe.example.Entities.Agence;
import pfe.example.Services.AgenceService;

@RestController
@RequestMapping("/api/agence")
public class AgenceController {
    @Autowired
    private AgenceService agenceService;

    @PostMapping("/create")
    public ResponseEntity<Agence> createAgence(@RequestBody Agence agence){
        Agence newAgence = agenceService.createAgence(agence);
        return ResponseEntity.status(HttpStatus.CREATED).body(newAgence);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Agence> updateAgence(@PathVariable String id, @RequestBody Agence agence) {
        Agence updatedAgence = agenceService.updateAgence(id, agence);
        return ResponseEntity.ok(updatedAgence);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAgence(@PathVariable String id) {
        agenceService.deleteAgence(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Agence> getAgenceById(@PathVariable String id) {
        Agence agence = agenceService.getAgenceById(id);
        return ResponseEntity.ok(agence);
    }
    @GetMapping("/all")
    public ResponseEntity<List<String>> getAllAdresses() {
        List<String> adresses = agenceService.getAllAdresses();
        return ResponseEntity.ok(adresses);
    }

    @GetMapping("/details/{nomAgence}")
    public ResponseEntity<AgenceDetailsDto> getDetailsAgence(@PathVariable String nomAgence) {
        return ResponseEntity.ok(agenceService.getDetailsParNomAgence(nomAgence));
    }
} 