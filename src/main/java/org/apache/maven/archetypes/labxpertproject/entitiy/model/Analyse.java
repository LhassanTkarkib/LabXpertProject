package org.apache.maven.archetypes.labxpertproject.entitiy.model;


import lombok.Data;
import org.apache.maven.archetypes.labxpertproject.entitiy.enums.StatutDanalyse;

import javax.persistence.*;
import java.util.*;
import java.time.*;


@Entity
@Data
@Table(name = "analyse")
public class Analyse {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "your_sequence_name")
    @SequenceGenerator(name = "your_sequence_name", sequenceName = "your_sequence_name", allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_planification")
    private Planification planification;

    @OneToMany(mappedBy = "analyse")
    private ArrayList<Resultat> resultats;

    @ManyToOne
    @JoinColumn(name = "id_echantillon")
    private Echantillon echantillon;

    @ManyToOne
    @JoinColumn(name = "id_utilisateur")
    private Utilisateur utilisateur;

    @OneToMany(mappedBy = "analyse")
    private ArrayList<Réactif> réactifs;

    @Column(name = "DateDebutAnalyse")
    LocalDate DateDebutAnalyse;

    @Column(name = "DateFinAnalyse")
    LocalDate DateFinAnalyse;

    @Column(name = "EtatAnalyse")
    StatutDanalyse EtatAnalyse;

    @Column(name = "Commentaire")
    String Commentaire;

}
