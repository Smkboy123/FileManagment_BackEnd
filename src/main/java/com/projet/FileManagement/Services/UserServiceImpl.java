package com.projet.FileManagement.Services;

import com.projet.FileManagement.Repository.UtilisateurRepository;
import com.projet.FileManagement.models.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UtilisateurService {
    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Override
    public Utilisateur creerCompte(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    @Override
    public Utilisateur login(String username, String password) {
        Utilisateur utilisateur = utilisateurRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (utilisateur.getPassword().equals(password)) {
            return utilisateur;
        } else {
            throw new RuntimeException("Invalid password");
        }
    }

    @Override
    public Utilisateur modifierCompte(Long userId, Utilisateur newUser) {
        Optional<Utilisateur> foundUser = utilisateurRepository.findById(userId);
        if (foundUser.isPresent()) {
            Utilisateur utilisateur = foundUser.get();
            utilisateur.setUsername(newUser.getUsername());
            utilisateur.setTelephone(newUser.getTelephone());
            utilisateur.setPassword(newUser.getPassword());
            return utilisateurRepository.save(utilisateur);
        } else {
            // lui demander de creer un compte
            return null;
        }
    }

    @Override
    public void supprimerCompte(Long userId) {
        utilisateurRepository.deleteById(userId);
    }

    @Override
    public Utilisateur afficherCompte(Long userId) {
        return utilisateurRepository.findById(userId).orElse(null);
    }

    //Afficher la liste
    @Override
    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    @Override
    public void ajouterTicket(Long IdFile, Long ticketId) {
        //
    }

    @Override
    public Optional<Utilisateur> findByUsername(String username) {
            return  utilisateurRepository.findByUsername(username);
        }

    }