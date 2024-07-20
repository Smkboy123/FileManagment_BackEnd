package com.projet.FileManagement.Services;

import com.projet.FileManagement.Repository.FileAttenteRepository;
import com.projet.FileManagement.models.FileAttente;
import com.projet.FileManagement.models.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FileAttenteServiceImp implements FileAttenteService {
    @Autowired
    private FileAttenteRepository fileAttenteRepository;

    //Creation
    @Override
    public FileAttente creerFile(FileAttente fileAttente){
        return fileAttenteRepository.save(fileAttente);
    }

    @Override
    public FileAttente modifierFile(Long idFile, FileAttente fileDetails) {
        Optional<FileAttente> file=fileAttenteRepository.findById(idFile);
        if (file.isPresent()){
            FileAttente fileAttente=file.get();
            fileAttente.setNomFile(fileDetails.getNomFile());
<<<<<<< HEAD
=======
            fileAttente.setDateCreation(fileDetails.getDateCreation());
>>>>>>> cf6b2c9e98c2aa77a4d3d76cbee550e733cb3aea
            return fileAttenteRepository.save(fileAttente);
        }else {
            return  null;
        }
    }

    //Afficher tous les fileAttentes
    @Override
    public List<FileAttente> getAllFiles(){
    return fileAttenteRepository.findAll();
    }
    //AFFICHER le nombre de personne dans la FileAttente
    @Override
    public List<Ticket> getNombredePersonne() {
        return List.of();
    }

    // Pour supprimer une FileAttente créer
    @Override
    public void supprimerFile(Long id){
        fileAttenteRepository.deleteById(id);
    }

    @Override
    public FileAttente afficherFile(Long idFile) {
        Optional<FileAttente> fileAttente=fileAttenteRepository.findById(idFile);
        return fileAttente.orElse(null);
    }
}
