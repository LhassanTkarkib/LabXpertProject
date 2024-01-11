package org.apache.maven.archetypes.labxpertproject.entitiy.model;

import lombok.Data;
import org.apache.maven.archetypes.labxpertproject.entitiy.enums.StatutDanalyse;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table(name = "analyse")
public class Analyse {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "your_sequence_name")
    @SequenceGenerator(name = "your_sequence_name", sequenceName = "your_sequence_name", allocationSize = 1)
    @Column(name = "analyse_id") // Specify the column name if it's different from the field name
    private Long analyseId; // Use camelCase for field names

    @ManyToOne
    @JoinColumn(name = "planification_id")
    private Planification planification;

    @OneToMany(mappedBy = "analyse")
    private List<Resultat> resultats;

    @ManyToOne
    @JoinColumn(name = "echantillon_id")
    private Echantillon echantillon;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

    @OneToMany(mappedBy = "analyse", cascade = CascadeType.ALL)
    private List<Reactif> reactifs;

    @Column(name = "DateDebutAnalyse")
    private LocalDate dateDebutAnalyse;

    @Column(name = "DateFinAnalyse")
    private LocalDate dateFinAnalyse;

    @Enumerated(EnumType.STRING)
    @Column(name = "EtatAnalyse")
    private StatutDanalyse etatAnalyse;

    @Column(name = "Commentaire")
    private String commentaire;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;
}
