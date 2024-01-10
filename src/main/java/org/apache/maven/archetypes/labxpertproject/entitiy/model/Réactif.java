package org.apache.maven.archetypes.labxpertproject.entitiy.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "réactif")
public class Réactif {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "your_sequence_name")
    @SequenceGenerator(name = "your_sequence_name", sequenceName = "your_sequence_name", allocationSize = 1)
    private Long id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "Description")
    private String Description;

    @Column(name = "quantite")
    private String quantite;

    @Column(name = "unite")
    private String unite;

    @Column(name = "dateDeexpiration")
    private String dateDeexpiration;

    @Column(name = "fournisseur")
    private String fournisseur;


}
