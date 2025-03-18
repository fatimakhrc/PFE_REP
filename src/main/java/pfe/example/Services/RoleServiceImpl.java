package pfe.example.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pfe.example.DAO.RoleRep;
import pfe.example.Entities.Roles;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRep roleRepository;
    @Override
    public Roles createRole(String nom) {
        Roles role = new Roles();
        role.setNom(nom);
        return roleRepository.save(role);
    }

    @Override
    public Roles getRoleByNom(String roleNom) {
        return roleRepository.findRoleByNom(roleNom).orElse(null);
    }
 
    @Override
    public Roles updateRole(Long id, String nom) {
        Optional<Roles> optionalRole = roleRepository.findById(id);
        if (optionalRole.isPresent()) {
            Roles role = optionalRole.get();
            role.setNom(nom);  // Met à jour le nom du rôle
            return roleRepository.save(role);  // Sauvegarde la mise à jour
        }
        return null;  // Si le rôle n'existe pas
    }

    @Override
    public boolean deleteRole(Long id) {
        Optional<Roles> optionalRole = roleRepository.findById(id);
        if (optionalRole.isPresent()) {
            roleRepository.deleteById(id);  // Supprime le rôle
            return true;
        }
        return false;  // Si le rôle n'existe pas
    }


}
