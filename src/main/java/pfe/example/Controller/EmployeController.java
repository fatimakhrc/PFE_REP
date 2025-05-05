package pfe.example.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pfe.example.Entities.Employe;
import pfe.example.Services.EmployeService;

@RestController
@RequestMapping("/api/employe")
public class EmployeController {

    @Autowired
    private EmployeService employeService;

    @GetMapping("/find/{cin}")
    public ResponseEntity<Employe> getEmployeByCin(@PathVariable String cin) {
        Employe employe = employeService.getEmployeByCin(cin);
        return ResponseEntity.ok(employe);
    }

    @PostMapping("/create")
    public ResponseEntity<Employe> createEmploye(@RequestBody Employe employe) {
        Employe newEmploye = employeService.createEmploye(employe);
        return ResponseEntity.status(HttpStatus.CREATED).body(newEmploye);
    }
}

