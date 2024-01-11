package org.apache.maven.archetypes.labxpertproject.repository;

import org.apache.maven.archetypes.labxpertproject.entitiy.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    Utilisateur findByNomUtilisateur(String sampleUser);
}
