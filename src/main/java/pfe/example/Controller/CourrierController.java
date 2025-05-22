package pfe.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pfe.example.Entities.Courrier;
import pfe.example.Entities.StatusCourrier;
import pfe.example.Services.CourrierService;

@RestController
@RequestMapping("/api/courriers")
public class CourrierController {
     @Autowired
    private CourrierService courrierService;

    @PostMapping("/create")
    public ResponseEntity<Courrier> createCourrier(@RequestBody Courrier courrier) {
        Courrier newCourrier = courrierService.creerCourrier(courrier);
        return ResponseEntity.ok(newCourrier);
    }

    @GetMapping("/all")
    public List<Courrier> getAllCourriers() {
        return courrierService.getAllCourriers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Courrier> getCourrierById(@PathVariable Long id) {
        Courrier courrier = courrierService.getCourrierById(id);
        return courrier != null ? ResponseEntity.ok(courrier) : ResponseEntity.notFound().build();
    }

    @GetMapping("/statut/{statut}")
    public List<Courrier> getCourriersByStatut(@PathVariable StatusCourrier statut) {
        return courrierService.getCourriersByStatut(statut);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Courrier> updateCourrier(@PathVariable Long id, @RequestBody Courrier courrierDetails) {
        Courrier updatedCourrier = courrierService.updateCourrier(id, courrierDetails);
        return updatedCourrier != null ? ResponseEntity.ok(updatedCourrier) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourrier(@PathVariable Long id) {
        courrierService.deleteCourrier(id);
        return ResponseEntity.noContent().build();
    }

}
