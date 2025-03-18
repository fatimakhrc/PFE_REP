package pfe.example.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pfe.example.DAO.DroitRep;
import pfe.example.Entities.Droits;

@Service
public class DroitServiceImpl implements DroitService{
    @Autowired
    private DroitRep droitRepository;

    @Override
    public Droits createDroit(String nomDroit) {
        Droits droit = new Droits();
        droit.setNomDroit(nomDroit);
        return droitRepository.save(droit);
    }

   /*  @Override
    public Droits getDroitByNomDroit(String nomDroit) {
        return droitRepository.findByNomDroit(nomDroit);
    } */

    @Override
    public List<Droits> getAllDroits() {
        return droitRepository.findAll();
    }

    @Override
    public boolean deleteDroit(Long id_droit) {
        if (droitRepository.existsById(id_droit)) {
            droitRepository.deleteById(id_droit);
            return true;
        }
        return false;
    }

    

}
