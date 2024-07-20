package com.projet.FileManagement.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idTicket;
    private StatutTicket status= StatutTicket.EN_COURS;
    private String numeroTicket;
    @Temporal(TemporalType.TIMESTAMP)
    private Date heurePrise=new Date(System.currentTimeMillis());
    private String telephonne;
<<<<<<< HEAD
    private String nom;
    private String prenom;
    private String telephone;
=======

>>>>>>> cf6b2c9e98c2aa77a4d3d76cbee550e733cb3aea
    //Un Utilisateur peut prendre des tickets mais un ticket appartient à un Utilisateur
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;
    //un ticket ne peu qu'appartenir qu'à une seule File Attente
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    @JoinColumn(name = "id_File")
    private FileAttente fileAttente;
    //Un Ticket genère des Notifications
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @OneToMany(mappedBy = "ticket")
    private List<Notification> notifications;
    //Ticket serviceModel
   // @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_service")
    private ServiceModel serviceModel;
}
