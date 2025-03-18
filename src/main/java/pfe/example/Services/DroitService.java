package pfe.example.Services;

import java.util.List;

import pfe.example.Entities.Droits;

public interface DroitService {
      // Créer un droit
    Droits createDroit(String nomDroit);

    /* // Récupérer un droit par son nom
    Droits getDroitByNomDroit(String nomDroit); */

    // Récupérer tous les droits
    List<Droits> getAllDroits();

    // Supprimer un droit par son ID
    boolean deleteDroit(Long id_droit);

}
