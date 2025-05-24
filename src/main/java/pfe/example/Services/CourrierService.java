package pfe.example.Services;

import java.util.List;

import pfe.example.DTO.CreeClientCourrierDto;
import pfe.example.Entities.Courrier;
import pfe.example.Entities.StatusCourrier;


public interface CourrierService {
    long genererIdCourrier();
    Courrier creerCourrier(Courrier courrier);
    List<Courrier> getAllCourriers();
    Courrier getCourrierById(Long id);
    List<Courrier> getCourriersByStatut(StatusCourrier statut);
    Courrier updateCourrier(Long id, Courrier courrierDetails);
    void deleteCourrier(Long id);
    Courrier creerCourrierDepuisDto(CreeClientCourrierDto dto);
}
