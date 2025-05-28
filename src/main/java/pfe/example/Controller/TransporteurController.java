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

import pfe.example.Entities.Transporteur;
import pfe.example.Services.TransporeteurService;

@RestController
@RequestMapping("/api/transporteur")
public class TransporteurController {
    @Autowired
    private TransporeteurService transporteurService;

    @PostMapping("/create")
    public ResponseEntity<Transporteur> createTransporteur(@RequestBody Transporteur transporteur) {
        Transporteur newTransporteur = transporteurService.createTransporteur(transporteur);
        return ResponseEntity.status(HttpStatus.CREATED).body(newTransporteur);
    }

    @PutMapping("/update/{trs_cin}")
    public ResponseEntity<Transporteur> updateTransporteur(@PathVariable String trs_cin, @RequestBody Transporteur transporteur) {
    Transporteur updatedTransporteur = transporteurService.updateTransporteur(trs_cin, transporteur);
    return ResponseEntity.ok(updatedTransporteur); // Retourne l'objet mis à jour avec code 200
}

    @GetMapping("/{trs_cin}")
    public ResponseEntity<Transporteur> getTransporteurById(@PathVariable String trs_cin) {
        Transporteur transporteur = transporteurService.getTransporteurById(trs_cin);
        return ResponseEntity.ok(transporteur);
    }

   @DeleteMapping("/delete/{trs_cin}")
    public ResponseEntity<Void> deleteTransporteur(@PathVariable String trs_cin) {
    transporteurService.deleteTransporteur(trs_cin);
    return ResponseEntity.noContent().build();
}
}
 