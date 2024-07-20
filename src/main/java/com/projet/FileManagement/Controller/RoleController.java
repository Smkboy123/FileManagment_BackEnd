package com.projet.FileManagement.Controller;


import com.projet.FileManagement.Services.RoleService;
import com.projet.FileManagement.Services.RoleServiceImp;
import com.projet.FileManagement.models.Role;
import com.projet.FileManagement.models.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
@CrossOrigin(origins = "http://localhost:4200")
public class RoleController {

    @Autowired
    private RoleServiceImp roleServiceImp;

    @PostMapping("/add")
    public ResponseEntity<Role> addRole(@RequestBody Role role){
        return ResponseEntity.ok(roleServiceImp.creerRole(role));
    }

    @PutMapping("/modifier/{id}")
    public ResponseEntity<Role> updateRole(@PathVariable Long id,@RequestBody Role roleDetail) {
        Role roleFound = roleServiceImp.modifierRole(id, roleDetail);
        return ResponseEntity.ok(roleFound);
    }
    @GetMapping("/list")
    public ResponseEntity<List<Role>> tousRoles(){
        List<Role> role=  roleServiceImp.getAllRoles();
        return ResponseEntity.ok(role);
    }
    @GetMapping("/list/{idRole}")
    public ResponseEntity<List<Utilisateur>> listByRole(@PathVariable Long idRole){
        roleServiceImp.afficherUtilisateursParRole(idRole);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/delete/{idRole}")
    public ResponseEntity<Void> supprimerRole(@PathVariable Long idRole) {
        roleServiceImp.deleteRole(idRole);
        return ResponseEntity.ok().build();
    }
    @PostMapping("/associer")
    public ResponseEntity<Void> attribuerRole(@RequestParam Long idRole, @RequestParam Long idUser){
        roleServiceImp.associerUtilisateur(idRole,idUser);
        return ResponseEntity.ok().build();
    }
    @PostMapping("/dissocier")
    public ResponseEntity<Void> dissocierRole(@RequestParam Long idRole, @RequestParam Long idUser){
        roleServiceImp.associerUtilisateur(idRole,idUser);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/afficher/{idRole}")
    public ResponseEntity<Role> afficherRole(@PathVariable Long idRole) {
        Role role = roleServiceImp.getRole(idRole);
        return ResponseEntity.ok(role);
    }
}
