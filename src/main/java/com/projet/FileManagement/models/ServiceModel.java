package com.projet.FileManagement.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

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
    private List<Ticket> ticketList=new ArrayList<>();
}
