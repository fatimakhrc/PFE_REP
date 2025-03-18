package pfe.example.Services;

import pfe.example.Entities.Roles;

public interface RoleService {
    Roles createRole(String nom);
    Roles getRoleByNom(String roleNom);
    Roles updateRole(Long id_role,String nom);
    boolean deleteRole(Long id);

}
