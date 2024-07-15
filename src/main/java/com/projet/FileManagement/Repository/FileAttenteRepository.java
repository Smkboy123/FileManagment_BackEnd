package com.projet.FileManagement.Repository;

import com.projet.FileManagement.models.FileAttente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileAttenteRepository extends JpaRepository<FileAttente,Long> {

}
