package pfe.example.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pfe.example.DAO.TransporteurRep;
import pfe.example.Entities.Transporteur;


@Service
public class TransporteurServiceImpl implements TransporeteurService{
    @Autowired
    private TransporteurRep transporteurRepository;
    @Override
    public Transporteur createTransporteur(Transporteur transporteur) {
        return transporteurRepository.save(transporteur);
    }

    @Override
    public Transporteur updateTransporteur(String trs_cin, Transporteur transporteur) {
        Transporteur existingTransporteur = transporteurRepository.findById(trs_cin)
            .orElseThrow(() -> new RuntimeException("Transporteur not found"));
        existingTransporteur.setTrs_nom(transporteur.getTrs_nom());
        existingTransporteur.setTrs_prenom(transporteur.getTrs_prenom());
        existingTransporteur.setTrs_Cin(transporteur.getTrs_Cin());
        existingTransporteur.setTrs_adress(transporteur.getTrs_adress());
        return transporteurRepository.save(existingTransporteur);
    }

    @Override
    public void deleteTransporteur(String trs_cin) {
        Transporteur transporteur = transporteurRepository.findById(trs_cin)
            .orElseThrow(() -> new RuntimeException("Transporteur not found"));
        transporteurRepository.delete(transporteur);
    }

    @Override
    public Transporteur getTransporteurById(String cin) {
        return transporteurRepository.findById(cin)
            .orElseThrow(() -> new RuntimeException("Transporteur not found"));
    }
    
}
