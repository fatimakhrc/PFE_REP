package pfe.example.Controller;


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

import pfe.example.Entities.Roles;
import pfe.example.Services.RoleService;

@RestController
@RequestMapping("/api/roles")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @PostMapping
    public ResponseEntity<Roles> createRole(@RequestBody String nom) {
        Roles role = roleService.createRole(nom);
        return ResponseEntity.status(201).body(role);
    }

    @GetMapping("/{nom}")
    public ResponseEntity<Roles> getRoleByName(@PathVariable String nom) {
        Roles role = roleService.getRoleByNom(nom);
        if (role != null) {
            return ResponseEntity.ok(role);
        }
        return ResponseEntity.notFound().build();
    } 

   // Mettre à jour un rôle par son id
   @PutMapping("/{id}")
   public ResponseEntity<Roles> updateRole(@PathVariable Long id_role, @RequestBody String nom) {
    Roles updatedRole = roleService.updateRole(id_role, nom);
    if (updatedRole != null) {
        return ResponseEntity.ok(updatedRole);
    }
    return ResponseEntity.notFound().build();
    }

     // Supprimer un rôle par son id
     @DeleteMapping("/{id_role}")
     public ResponseEntity<Void> deleteRole(@PathVariable Long id_role) {
         boolean isDeleted = roleService.deleteRole(id_role);
         if (isDeleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }


}







