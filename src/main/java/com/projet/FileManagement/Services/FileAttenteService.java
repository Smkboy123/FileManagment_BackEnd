package com.projet.FileManagement.Services;

import com.projet.FileManagement.models.FileAttente;
import com.projet.FileManagement.models.Ticket;

import java.util.List;

public interface FileAttenteService {
    FileAttente creerFile(FileAttente fileAttente);
    FileAttente modifierFile(Long idFile, FileAttente fileAttenteDetails);
    void supprimerFile(Long idFile);
    FileAttente afficherFile(Long idFile);
    List<FileAttente> getAllFiles();
    List<Ticket> getNombredePersonne();
}
