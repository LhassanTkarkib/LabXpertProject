package org.apache.maven.archetypes.labxpertproject.entitiy.model;

import lombok.Data;
import org.apache.maven.archetypes.labxpertproject.entitiy.enums.StatutDeResultat;

import javax.persistence.*;

@Entity
@Data
@Table(name = "SousAnalyse")
public class SousAnalyse {

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

    @ManyToOne (cascade = CascadeType.REMOVE)
    @JoinColumn(name = "analyse_id")
    private Analyse analyse;
}
