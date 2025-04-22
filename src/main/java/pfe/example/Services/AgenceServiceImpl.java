package pfe.example.Services;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import java.util.Optional;

import pfe.example.DAO.AgenceRep;
import pfe.example.Entities.Agence;

@Service
public class AgenceServiceImpl implements AgenceService {
    @Autowired
    private AgenceRep agenceRepository;

    @Override
    public Agence getAgenceById(String id) {
        Optional<Agence> agence = agenceRepository.findById(id);  // Appeler la méthode findById du repository
        return agence.orElse(null);  // Return the Agence object if found, otherwise return null
    }

    @Override
    public Agence createAgence(Agence agence) {
        return agenceRepository.save(agence);
    }
    @Override
    public Agence updateAgence(String id, Agence agence) {
        Agence existingAgence = agenceRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Agence not found"));
        existingAgence.setNom_agence(agence.getNom_agence());
        existingAgence.setAdresse_agence(agence.getAdresse_agence());
        return agenceRepository.save(existingAgence);
    }
    @Override
    public void deleteAgence(String id) {
        Agence agence = agenceRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Agence not found"));
            agenceRepository.delete(agence);
    }

    
}

    
    
    
