package com.projet.FileManagement.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;
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
public class FileAttente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idFile;
    private String nomFile;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation=new Date(System.currentTimeMillis());
//Des files attente sont créer par un utilisateur
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_utilisateur")
    private Utilisateur utilisateur;
//Une fil est composé de tickets
@JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @OneToMany(mappedBy = "fileAttente")
    private List<Ticket> tickets;
}
