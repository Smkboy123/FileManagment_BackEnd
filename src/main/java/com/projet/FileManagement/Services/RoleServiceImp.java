package com.projet.FileManagement.Services;

import com.projet.FileManagement.Repository.RoleRepository;
import com.projet.FileManagement.Repository.UtilisateurRepository;
import com.projet.FileManagement.models.Role;
import com.projet.FileManagement.models.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImp implements RoleService {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UtilisateurRepository utilisateurRepository;
    @Override
    public Role creerRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role modifierRole(Long idRole, Role roleDetails) {
        Optional<Role> foundRole= roleRepository.findById(idRole);
        if(foundRole!=null){
            Role roleTrouve=foundRole.get();
            roleTrouve.setNomRole(roleDetails.getNomRole());
            return roleRepository.save(roleTrouve);
        }
        return null;
    }

    @Override
    public Role getRole(Long idRole) {
        return roleRepository.findById(idRole).orElse(null);
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public void associerUtilisateur(Long idRole, Long idUtilisateur) {
        Optional<Role> roleTrouver=roleRepository.findById(idRole);
        Optional<Utilisateur> userfound=utilisateurRepository.findById(idUtilisateur);
        if (roleTrouver.isPresent()&& userfound.isPresent()){
            userfound.get().getRoles().add(roleTrouver.get());
             utilisateurRepository.save(userfound.get());
        }
    }

    @Override
    public void dissocierUtilisateur(Long idRole, Long idUtilisateur) {
        Optional<Role> roleTrouver = roleRepository.findById(idRole);
        Optional<Utilisateur> userfound = utilisateurRepository.findById(idUtilisateur);
        if (roleTrouver.isPresent() && userfound.isPresent()) {
            userfound.get().getRoles().remove(roleTrouver.get());
            utilisateurRepository.save(userfound.get());
        }
    }
    @Override
    public List<Utilisateur> afficherUtilisateursParRole(Long idRole) {
        Optional<Role> rolefound=roleRepository.findById(idRole);
        if (rolefound.isPresent()){
            return rolefound.get().getUtilisateurs();
        }else
         return List.of();
    }

    @Override
    public void deleteRole(Long idRole) {
        roleRepository.deleteById(idRole);
    }
}
