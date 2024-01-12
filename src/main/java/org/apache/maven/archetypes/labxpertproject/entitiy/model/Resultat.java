package org.apache.maven.archetypes.labxpertproject.entitiy.model;

import lombok.Data;
import org.apache.maven.archetypes.labxpertproject.entitiy.enums.StatutDeResultat;

import javax.persistence.*;

@Entity
@Data
@Table(name = "resultat")
public class Resultat {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "your_sequence_name")
    @SequenceGenerator(name = "your_sequence_name", sequenceName = "your_sequence_name", allocationSize = 1)
    private Long resultatId;

    @Column(name = "resultat")
    private String resultat;

    @Column(name = "uniteDeMesure")
    private String uniteDeMesure;

    @Enumerated(EnumType.STRING)
    @Column(name = "statutDeResultat")
    private StatutDeResultat statutDeResultat;

    @ManyToOne
    @JoinColumn(name = "analyse_id")
    private Analyse analyse;
}
