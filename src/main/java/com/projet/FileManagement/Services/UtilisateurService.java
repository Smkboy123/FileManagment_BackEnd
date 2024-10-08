package com.projet.FileManagement.Services;
import com.projet.FileManagement.models.Utilisateur;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;


public interface UtilisateurService extends UserDetailsService {

    Utilisateur creerCompte(Utilisateur utilisateur);
    Utilisateur modifierCompte(Long userId, Utilisateur utilisateurDetails);
    void supprimerCompte(Long userId);
    Utilisateur afficherCompte(Long userId);
    List<Utilisateur> getAllUtilisateurs();
    void ajouterTicket(Long IdFile, Long ticketId);
    Optional<Utilisateur> findByUsername(String username);
    Utilisateur login (String username, String password);
}