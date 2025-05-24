package pfe.example.Services;

import pfe.example.Entities.Agence;
import java.util.List;

public interface AgenceService {
    Agence createAgence (Agence agence);
    Agence getAgenceById(String id);
    Agence updateAgence(String id, Agence agence);
    void deleteAgence(String id);
    List <String> getAllAdresses();
    
    
}
