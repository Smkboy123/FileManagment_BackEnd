package com.projet.FileManagement.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idNotification;
    private String message;
    @Temporal(TemporalType.TIMESTAMP)
    private Date heureEnvoie= new Date(System.currentTimeMillis());
    //Des notifications peuvent etre generer par un ticket
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_ticket")
    private Ticket ticket;
}
