package com.projet.FileManagement.Controller;


import com.projet.FileManagement.Exception.ApiConstants;
import com.projet.FileManagement.Services.RoleService;
import com.projet.FileManagement.Services.UtilisateurService;
import com.projet.FileManagement.models.RegisterForm;
import com.projet.FileManagement.models.Role;
import com.projet.FileManagement.models.RoleName;
import com.projet.FileManagement.models.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping(ApiConstants.API_VERSION_ONE + "users")
@CrossOrigin(origins = "http://localhost:4200")
public class UtilisateurController {
    @Autowired
    private UtilisateurService utilisateurService;
    @Autowired
    private  PasswordEncoder passwordEncoder;
    @Autowired
    private RoleService roleService;


    @PostMapping("/creer")
    public ResponseEntity<Utilisateur> creerCompte(@RequestBody RegisterForm registerForm){

        System.out.println("UTILISATEUR = "+registerForm.getRole());

        Set<String> strRoles = registerForm.getRole();
        Set<Role> roles = new HashSet<>();
        if(strRoles != null){
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleService.getRoleByName(RoleName.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
                        roles.add(adminRole);
                    case "user":
                        Role userRoles = roleService.getRoleByName(RoleName.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
                        roles.add(userRoles);

                        break;

                    default:
                        Role userRole = roleService.getRoleByName(RoleName.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
                        roles.add(userRole);
                }
            });
        }
        else {
            Role userRole = roleService.getRoleByName(RoleName.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
            roles.add(userRole);
        }
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setUsername(registerForm.getUsername());
        utilisateur.setTelephone(registerForm.getTelephone());
        utilisateur.setRoles(roles);
        utilisateur.setPassword(passwordEncoder.encode(registerForm.getPassword()));
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
