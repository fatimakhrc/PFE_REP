package pfe.example.DTO;


import pfe.example.DTO.VehiculeDto;

import java.util.List;

import pfe.example.DTO.EmployeAgenceDto;

public class AgenceDetailsDto {
    private String nomAgence;
    private List<EmployeAgenceDto> employes;
    private List<VehiculeDto> vehicules;


    public AgenceDetailsDto() {
    }

    public AgenceDetailsDto(String nomAgence, List<EmployeAgenceDto> employes, List<VehiculeDto> vehicules) {
        this.nomAgence = nomAgence;
        this.employes = employes;
        this.vehicules = vehicules;
    }
    
    public String getNomAgence() {
        return nomAgence;
    }
    public void setNomAgence(String nomAgence) {
        this.nomAgence = nomAgence;
    }
    public List<EmployeAgenceDto> getEmployes() {
        return employes;
    }
    public void setEmployes(List<EmployeAgenceDto> employes) {
        this.employes = employes;
    }
    public List<VehiculeDto> getVehicules() {
        return vehicules;
    }
    public void setVehicules(List<VehiculeDto> vehicules) {
        this.vehicules = vehicules;
    }
}
