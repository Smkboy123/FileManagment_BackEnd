package com.projet.FileManagement.Services;

import com.projet.FileManagement.Repository.RoleRepository;
import com.projet.FileManagement.models.Role;
import com.projet.FileManagement.models.RoleName;
import com.projet.FileManagement.models.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface RoleService {
    Role creerRole(Role role);
    Role modifierRole(Long idRole, Role roleDetails);
    Role getRole(Long idRole);
    List<Role> getAllRoles();
    void associerUtilisateur(Long idRole, Long idUtilisateur);
    void dissocierUtilisateur(Long idRole, Long idUtilisateur);
    List<Utilisateur> afficherUtilisateursParRole(Long idRole);
    void deleteRole(Long idRole);


    Optional<Role> getRoleByName(RoleName roleName);


}
