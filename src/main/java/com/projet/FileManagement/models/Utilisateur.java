package com.projet.FileManagement.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idUtilisateur;
    private String username;
    private String prenom;
    private String password;
    private String email;
    private String telephone;
    //Un Utilisateur peut avoir plusieurs rôles et un rôle peut etre attribuer à plsrs users
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> roles=new ArrayList<>();

    //Un Utilisateur peut prendre des tickets
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @OneToMany(mappedBy = "utilisateur")
    private List<Ticket> tickets;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @OneToMany(mappedBy = "utilisateur")
    private List<FileAttente> fileAttentes;
}