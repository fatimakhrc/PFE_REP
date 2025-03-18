package pfe.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pfe.example.Entities.Droits;
import pfe.example.Services.DroitService;

@RestController
@RequestMapping("/api/Droits")
public class DroitsController {
    @Autowired
    private DroitService droitService;

    // Créer un droit
    @PostMapping("/create")
    public ResponseEntity<Droits> createDroit(@RequestParam String nomDroit) {
    Droits droit = droitService.createDroit(nomDroit);
        return new ResponseEntity<>(droit, HttpStatus.CREATED);
    }

    /* // Récupérer un droit par son nom
    @GetMapping("/{nomDroit}")
    public ResponseEntity<Droits> getDroitByNom(@PathVariable String nom) {
        Droits droit = droitService.getDroitByNom(nom);
        if (droit != null) {
            return new ResponseEntity<>(droit, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    } */

    // Récupérer tous les droits
    @GetMapping("/all")
    public List<Droits> getAllDroits() {
        return droitService.getAllDroits();
    }

    // Supprimer un droit par son ID
    @DeleteMapping("/delete/{id_droit}")
    public ResponseEntity<Void> deleteDroit(@PathVariable Long id_droit) {
        boolean isDeleted = droitService.deleteDroit(id_droit);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }  

}
