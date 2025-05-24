/*package pfe.example.Services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;

import pfe.example.DAO.CourrierRep;
import pfe.example.DAO.SuiviCourrierRep;
import pfe.example.Entities.Courrier;
import pfe.example.Entities.SuiviCourrier;

public class SuiviCourrierServiceImpl implements SuiviCourrierService {
    @Autowired
    private CourrierRep courrierRepository;

    @Autowired
    private SuiviCourrierRep suiviCourrierRepository;

    @Override
    public SuiviCourrier enregistrerPosition(Long courrierId, double lat, double lng) {
        Courrier courrier = courrierRepository.findById(courrierId)
                .orElseThrow(() -> new RuntimeException("Courrier non trouvé"));

        SuiviCourrier suivi = new SuiviCourrier();
        suivi.setCourrier(courrier);
        suivi.setLatitude(lat);
        suivi.setLongitude(lng);
        suivi.setDateSuivi(LocalDateTime.now());

        return suiviCourrierRepository.save(suivi);
    }

    @Override
    public SuiviCourrier obtenirDernierePosition(Long courrierId) {
        Courrier courrier = courrierRepository.findById(courrierId)
                .orElseThrow(() -> new RuntimeException("Courrier non trouvé"));
        return suiviCourrierRepository.findTopByCourrierOrderByDateSuiviDesc(courrier);
    
    }
}
*/