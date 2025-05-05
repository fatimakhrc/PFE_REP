package pfe.example.DAO;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pfe.example.Entities.Roles;

@Repository
public interface RoleRep extends JpaRepository <Roles,Long>{
    Optional <Roles> findRoleByNom(String nom);
}