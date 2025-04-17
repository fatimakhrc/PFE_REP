package pfe.example.Services;

import java.util.List;


import pfe.example.Entities.Courrier;

public interface CourrierService {
    long genererIdCourrier();
    Courrier creerCourrier(Courrier courrier);
    List<Courrier> getAllCourriers();
    Courrier getCourrierById(Long id);
    List<Courrier> getCourriersByStatut(String statut);
    Courrier updateCourrier(Long id, Courrier courrierDetails);
    void deleteCourrier(Long id);
    
}
