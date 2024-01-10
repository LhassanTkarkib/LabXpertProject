package org.apache.maven.archetypes.labxpertproject.entitiy.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "your_sequence_name")
    @SequenceGenerator(name = "your_sequence_name", sequenceName = "your_sequence_name", allocationSize = 1)
    private Long id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "date_de_naissance")
    private LocalDate dateDeNaissance;

    @Column(name = "sexe")
    private String sexe;

    @Column(name = "adresse")
    private String adresse;

    @Column(name = "telephone")
    private String telephone;

    @OneToMany(mappedBy = "patient")
    private List<Analyse> analyseHistory;

    @OneToMany(mappedBy = "patient")
    private ArrayList<Echantillon> echantillons;


}