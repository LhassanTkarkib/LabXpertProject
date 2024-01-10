package org.apache.maven.archetypes.labxpertproject.entitiy.model;

import lombok.Data;
import org.apache.maven.archetypes.labxpertproject.entitiy.enums.RoleDutilisateur;

import javax.persistence.*;

@Entity
@Data
@Table(name = "utilisateur")
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "your_sequence_name")
    @SequenceGenerator(name = "your_sequence_name", sequenceName = "your_sequence_name", allocationSize = 1)
    private Long id;

    @Column(name = "nomutilisateur")
    private String nomUtilisateur;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String Password;

    @Column(name = "roleDutilisateur")
    private RoleDutilisateur roleDutilisateur;

    @Column(name = "informationsPersonalises")
    private String informationsPersonalises;

}
