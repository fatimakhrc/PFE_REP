package pfe.example.Services;

import pfe.example.DTO.AgenceDetailsDto;
import pfe.example.Entities.Agence;
import java.util.List;

public interface AgenceService {
    Agence createAgence (Agence agence);
    Agence getAgenceById(Long id);
    Agence updateAgence(Long id, Agence agence);
    void deleteAgence(Long id);
    List <String> getAllAdresses();
    AgenceDetailsDto getDetailsParNomAgence (String nomAgence);
    List<Long> getAllAgenceIds();

    
    
}