package com.projet.FileManagement.Services;
import com.projet.FileManagement.models.Utilisateur;
import java.util.List;
import java.util.Optional;


public interface UtilisateurService {

    Utilisateur creerCompte(Utilisateur utilisateur);
    Utilisateur modifierCompte(Long userId, Utilisateur utilisateurDetails);
    void supprimerCompte(Long userId);
    Utilisateur afficherCompte(Long userId);
    List<Utilisateur> getAllUtilisateurs();
    void ajouterTicket(Long IdFile, Long ticketId);
    Optional<Utilisateur> findByUsername(String username);
<<<<<<< HEAD
    Utilisateur login (String username, String password);
=======
>>>>>>> cf6b2c9e98c2aa77a4d3d76cbee550e733cb3aea
}