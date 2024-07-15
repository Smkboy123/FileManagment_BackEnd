package com.projet.FileManagement.Repository;

import com.projet.FileManagement.models.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long> {
    Optional<Utilisateur> findByUsername(String username);
}
