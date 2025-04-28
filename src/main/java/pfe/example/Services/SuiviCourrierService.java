package pfe.example.Services;

import pfe.example.Entities.SuiviCourrier;

public interface SuiviCourrierService {
    SuiviCourrier enregistrerPosition(Long courrierId, double lat, double lng);
    SuiviCourrier obtenirDernierePosition(Long courrierId);

}
