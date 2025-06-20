package pfe.example.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import pfe.example.DAO.EmployeRep;
import pfe.example.Entities.Agence;
import pfe.example.Entities.Employe;

@Service
public class EmployeServiceImpl implements EmployeService {
    @Autowired
    private EmployeRep employeRepository;

    @Autowired
    private AgenceService agenceService; // service pour obtenir les agences

    @Override
    public Employe createEmploye(Employe employe) {
        return employeRepository.save(employe);
    }

    @Override
    public Employe updateEmploye(String emp_cin, Employe updatedEmploye) {
        Optional<Employe> employeOpt = employeRepository.findByEmpCin(emp_cin);
        if (employeOpt.isPresent()) {
            Employe employe = employeOpt.get();
            if (updatedEmploye.getNom_emp() != null) employe.setNom_emp(updatedEmploye.getNom_emp());
            if (updatedEmploye.getPrenom_emp() != null) employe.setPrenom_emp(updatedEmploye.getPrenom_emp());
            if (updatedEmploye.getEmpCin() != null) employe.setEmpCin(updatedEmploye.getEmpCin());
            if (updatedEmploye.getEmp_phone() != null) employe.setEmpCin(updatedEmploye.getEmp_phone());
            if (updatedEmploye.getEmp_adresse() != null) employe.setEmpCin(updatedEmploye.getEmp_adresse());
            if(updatedEmploye.getAgence() != null) employe.setAgence(updatedEmploye.getAgence());
            return employeRepository.save(employe);
        }
        return null;
    }

    @Override
    public boolean deleteEmploye(String emp_cin) {
        if (employeRepository.existsById(emp_cin)) {
            employeRepository.deleteById(emp_cin);
            return true;
        }
        return false;
    }

    @Override
    public Employe getEmployeByCin(String emp_cin) {
        return employeRepository.findByEmpCin(emp_cin).orElse(null);
    }

    @Override
    public List<Employe> getAllEmployes() {
        return employeRepository.findAll();
    }

    @Override
    public Employe affecterEmployeAgence(String employeCin, Long agenceId) {
    Optional<Employe> employeOpt = employeRepository.findByEmpCin(employeCin);
    if (employeOpt.isPresent()) {
        Employe employe = employeOpt.get();
        Agence agence = agenceService.getAgenceById(agenceId);
        if (agence != null) {
            employe.setAgence(agence);
            return employeRepository.save(employe);
        }
    }
    return null;
}
}

