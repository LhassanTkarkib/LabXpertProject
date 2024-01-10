package org.apache.maven.archetypes.labxpertproject.entitiy.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Data
@Table(name = "planification")
public class Planification {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "your_sequence_name")
    @SequenceGenerator(name = "your_sequence_name", sequenceName = "your_sequence_name", allocationSize = 1)
    private Long id;

    @OneToMany(mappedBy = "planification")
    private ArrayList<Analyse> analyses;

    @ManyToOne
    @JoinColumn(name = "id_utilisateur")
    private Utilisateur utilisateur;

    @Column(name = "DateDebutPlanification")
    private String DateDebutPlanification;

    @Column(name = "DateFinPlanification")
    private String DateFinPlanification;
}
