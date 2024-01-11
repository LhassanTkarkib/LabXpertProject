package org.apache.maven.archetypes.labxpertproject.entitiy.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table(name = "planification")
public class Planification {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "your_sequence_name")
    @SequenceGenerator(name = "your_sequence_name", sequenceName = "your_sequence_name", allocationSize = 1)
    @Column(name = "planification_id") // Specify the column name if it's different from the field name
    private Long planificationId; // Use camelCase for field names

    @OneToMany(mappedBy = "planification")
    private List<Analyse> analyses;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

    @Column(name = "DateDebutPlanification")
    private LocalDate dateDebutPlanification;

    @Column(name = "DateFinPlanification")
    private LocalDate dateFinPlanification;
}
