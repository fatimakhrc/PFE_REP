package pfe.example.Services;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import pfe.example.DAO.AgenceRep;
import pfe.example.DAO.TransporteurRep;
import pfe.example.DAO.UtilisateurRep;
import pfe.example.DAO.VehiculeRep;
import pfe.example.DTO.AgenceDetailsDto;
import pfe.example.DTO.EmployeAgenceDto;
import pfe.example.DTO.VehiculeDto;
import pfe.example.Entities.Agence;
import pfe.example.Entities.Employe;
import pfe.example.Entities.Transporteur;
import pfe.example.Entities.Vehicule;


@Service
public class AgenceServiceImpl implements AgenceService {
    @Autowired
    private AgenceRep agenceRepository;

    @Autowired 
    private VehiculeRep vehiculeRepository;

    @Autowired 
    private UtilisateurRep utilisateurRepository;

    @Autowired 
    private TransporteurRep transporteurRepository;

    @Override
    public Agence getAgenceById(Long id) {
        Optional<Agence> agence = agenceRepository.findById(id);  // Appeler la méthode findById du repository
        return agence.orElse(null);  // Return the Agence object if found, otherwise return null
    }

    @Override
    public List<Long> getAllAgenceIds() {
        return agenceRepository.findAll()
                        .stream()
                        .map(Agence::getId_agence) 
                        .collect(Collectors.toList());
    }

    @Override
    public Agence createAgence(Agence agence) {
        return agenceRepository.save(agence);
    }

    @Override
    public Agence updateAgence(Long id, Agence agence) {
        Agence existingAgence = agenceRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Agence not found"));
        existingAgence.setNomAgence(agence.getNomAgence());
        existingAgence.setAdresse_agence(agence.getAdresse_agence());
        return agenceRepository.save(existingAgence);
    }
    @Override
    public void deleteAgence(Long id) {
        Agence agence = agenceRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Agence not found"));
            agenceRepository.delete(agence);
    }

    @Override
    public List<String> getAllAdresses() {
        return agenceRepository.findAllAdresses();
    }


    @Override
    public AgenceDetailsDto getDetailsParNomAgence(String nomAgence) {
    Agence agence = agenceRepository.findByNomAgence(nomAgence)
        .orElseThrow(() -> new RuntimeException("Agence non trouvée"));

    AgenceDetailsDto dto = new AgenceDetailsDto();
    dto.setNomAgence(agence.getNomAgence());

    // Employés
    List<EmployeAgenceDto> employesDtos = new ArrayList<>();

    for (Employe e : agence.getEmployes()) {
        EmployeAgenceDto edto = new EmployeAgenceDto();
        edto.setCin(e.getEmpCin());
        edto.setNom(e.getNom_emp());
        edto.setPrenom(e.getPrenom_emp());
        edto.setAdresse(e.getEmp_adresse());
        edto.setEmp_phone(e.getEmp_phone());

        utilisateurRepository.findByEmploye(e).ifPresent(u -> {
            edto.setEmail(u.getEmail());
            edto.setMot_passe(u.getMot_passe());
        });

        employesDtos.add(edto);
    }

    // Transporteurs & Véhicules
    List<VehiculeDto> vehiculesDtos = new ArrayList<>();
    List<Vehicule> vehicules = vehiculeRepository.findByAgenceVehicule(agence);
    for (Vehicule v : vehicules) {
        Transporteur t = v.getTransporteurVehicule();
        if (t != null) {
            EmployeAgenceDto tDto = new EmployeAgenceDto();
            tDto.setCin(t.getTrs_Cin());
            tDto.setNom(t.getNom_trs());
            tDto.setPrenom(t.getPrenom_trs());
            tDto.setAdresse(t.getTrs_adress());
            tDto.setEmail("-");
            tDto.setMot_passe("-");
            employesDtos.add(tDto);

            VehiculeDto vdto = new VehiculeDto();
            vdto.setImmatriculation(v.getImtrc());
            vdto.setCapacite(v.getCapacite());
            vdto.setType(v.getType());
            vehiculesDtos.add(vdto);
        }
    }

    dto.setEmployes(employesDtos);
    dto.setVehicules(vehiculesDtos);
    return dto;
}

    
} 

    
    
    
