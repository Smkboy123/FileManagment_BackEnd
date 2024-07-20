package com.projet.FileManagement.Controller;

import com.projet.FileManagement.Services.FileAttenteService;
import com.projet.FileManagement.models.FileAttente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/file")
@CrossOrigin(origins = "http://localhost:4200")
public class FileAttenteController {
    @Autowired
    private FileAttenteService fileAttenteService;

    @PostMapping("/creer")
    public ResponseEntity<FileAttente> creerFile(@RequestBody FileAttente fileAttente){
        return ResponseEntity.ok(fileAttenteService.creerFile(fileAttente));
    }

    @PutMapping("/modifier/{idfile}")
    public ResponseEntity<FileAttente> modifierFile(@PathVariable Long idfile, @RequestBody FileAttente fileAttente) {
        FileAttente file = fileAttenteService.modifierFile(idfile, fileAttente);
        if (file != null) {
        return ResponseEntity.ok(file);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<FileAttente> supprimerFile(@PathVariable Long id){
        fileAttenteService.supprimerFile(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/list")
    public ResponseEntity<List<FileAttente>> getAllFiles(){
       List<FileAttente> listes=fileAttenteService.getAllFiles();
        return ResponseEntity.ok(listes);
    }
    @GetMapping("/{id}")
    public ResponseEntity<FileAttente> AfficheUneFile(@PathVariable Long idfile){
        FileAttente filetrouver=fileAttenteService.afficherFile(idfile);
        return ResponseEntity.ok(filetrouver);
    }
}
