package pfe.example.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pfe.example.DTO.PositionDTO;
import pfe.example.Entities.SuiviCourrier;
import pfe.example.Services.SuiviCourrierService;

@RestController
@RequestMapping("/api/suivi")
public class SuiviCourrierController {
    @Autowired
    private SuiviCourrierService suiviCourrierService;

    @PostMapping("/position")
    public ResponseEntity<SuiviCourrier> enregistrerPosition(@RequestBody PositionDTO dto) {
        SuiviCourrier suivi = suiviCourrierService.enregistrerPosition(dto.getCourrierId(), dto.getLatitude(), dto.getLongitude());
        return ResponseEntity.ok(suivi);
    }

    @GetMapping("/dernier/{courrierId}")
    public ResponseEntity<SuiviCourrier> getDernierePosition(@PathVariable Long courrierId) {
        SuiviCourrier suivi = suiviCourrierService.obtenirDernierePosition(courrierId);
        return ResponseEntity.ok(suivi);
    }

}
