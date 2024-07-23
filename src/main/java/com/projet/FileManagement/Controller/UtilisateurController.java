package com.projet.FileManagement.Controller;


import com.projet.FileManagement.Services.UtilisateurService;
import com.projet.FileManagement.models.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UtilisateurController {
    @Autowired
    private UtilisateurService utilisateurService;

    @PostMapping("/creer")
    public ResponseEntity<Utilisateur> creerCompte(@RequestBody Utilisateur utilisateur){
        Utilisateur newCompte=utilisateurService.creerCompte(utilisateur);
        return ResponseEntity.ok(newCompte);
    }




    @PostMapping("/login")
    public ResponseEntity<Utilisateur> login(@RequestParam String username, @RequestParam String password) {
        try {
            Utilisateur utilisateur = utilisateurService.login(username, password);
            return ResponseEntity.ok(utilisateur);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }


    @PutMapping("/modifier/{id}")
    public ResponseEntity<Utilisateur> updateCompte(@PathVariable Long id,@RequestBody Utilisateur newCompte){
        Utilisateur updateCompte=utilisateurService.modifierCompte(id,newCompte);
        if(updateCompte!=null){
            return ResponseEntity.ok(updateCompte);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Utilisateur> supprimerCompte(@PathVariable Long id){
        utilisateurService.supprimerCompte(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/list")
    public ResponseEntity<List<Utilisateur>> listesCompte(){
        List<Utilisateur> listes= utilisateurService.getAllUtilisateurs();
        return ResponseEntity.ok(listes);
    }
    @GetMapping("afficher/{username}")
    public ResponseEntity<Utilisateur> afficherCompte(@PathVariable String username){
        Optional<Utilisateur> Compte =utilisateurService.findByUsername(username);
       if(Compte.isPresent()){
           return ResponseEntity.ok(Compte.get());
        }else {
           return ResponseEntity.notFound().build();
       }
    }



}
