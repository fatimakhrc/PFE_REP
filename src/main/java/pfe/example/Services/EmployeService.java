package pfe.example.Services;

import java.util.List;

import pfe.example.Entities.Employe;

public interface EmployeService {
    Employe createEmploye(Employe employe);
    Employe updateEmploye(String cin, Employe employe);
    boolean deleteEmploye(String cin);
    Employe getEmployeByCin(String cin);
    List<Employe> getAllEmployes();
    Employe affecterEmployeAgence(String employeCin, String agenceId);  //  méthode pour affecter un employé à une agence

}
