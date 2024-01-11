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
    private Long utilisateurId; // Use camelCase for field names

    @Column(name = "nomutilisateur")
    private String nomUtilisateur;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password; // Consider using encryption or hashing

    @Enumerated(EnumType.STRING)
    @Column(name = "roleDutilisateur")
    private RoleDutilisateur roleDutilisateur;

    @Column(name = "informationsPersonnalises") // Use camelCase for field names
    private String InformationsPersonalises;
}
