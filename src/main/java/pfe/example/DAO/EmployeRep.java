package pfe.example.DAO;


import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pfe.example.Entities.Employe;

@Repository
public interface EmployeRep extends JpaRepository<Employe, String> {
    Optional <Employe> findByEmp_cin(String emp_cin);
}