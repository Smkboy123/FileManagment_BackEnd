package com.projet.FileManagement.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

<<<<<<< HEAD
import java.util.ArrayList;
=======
>>>>>>> cf6b2c9e98c2aa77a4d3d76cbee550e733cb3aea
import java.util.List;

@Entity
@Table(name = "Service")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class ServiceModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idService;
    private String nomService;
    private String description;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "serviceModel")
<<<<<<< HEAD
    private List<Ticket> ticketList=new ArrayList<>();
=======
    private List<Ticket> ticketList;
>>>>>>> cf6b2c9e98c2aa77a4d3d76cbee550e733cb3aea
}
