package org.apache.maven.archetypes.labxpertproject.entitiy.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "reactif")
public class Reactif {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "your_sequence_name")
    @SequenceGenerator(name = "your_sequence_name", sequenceName = "your_sequence_name", allocationSize = 1)
    @Column(name = "reactif_id") // Specify the column name if it's different from the field name
    private Long reactifId; // Use camelCase for field names

    @Column(name = "nom")
    private String nom;

    @Column(name = "Description")
    private String description; // Use camelCase for field names

    @Column(name = "quantite")
    private int quantite; // Assuming it represents a numerical quantity

    @Column(name = "unite")
    private String unite;

    @Column(name = "dateDeexpiration")
    private String dateDeExpiration; // Use camelCase for field names

    @Column(name = "fournisseur")
    private String fournisseur;

    @ManyToOne
    @JoinColumn(name = "analyse_id")
    private Analyse analyse;

}
