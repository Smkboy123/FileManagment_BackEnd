package com.projet.FileManagement.Repository;

import com.projet.FileManagement.models.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long> {
    Optional<Utilisateur> findByUsername(String username);


    @Modifying
    @Transactional
    @Query(value = "INSERT INTO utilisateur (id_utilisateur,username,password,telephone) VALUES (1,'moussa',:password,'91145946');",nativeQuery = true)
    void createAdminAccount(String password);
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO role_user(id_user,id_role) VALUES (1,1);",nativeQuery = true)
    void addRoleToAdmin();
}
