package org.apache.maven.archetypes.labxpertproject.entitiy.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table(name = "echantillon")
public class Echantillon {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "your_sequence_name")
    @SequenceGenerator(name = "your_sequence_name", sequenceName = "your_sequence_name", allocationSize = 1)
    @Column(name = "echantillon_id") // Specify the column name if it's different from the field name
    private Long echantillonId; // Use camelCase for field names

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @OneToMany(mappedBy = "echantillon")
    private List<Analyse> analyses;

    @Column(name = "date_prelevement")
    private LocalDate datePrelevement;
}
