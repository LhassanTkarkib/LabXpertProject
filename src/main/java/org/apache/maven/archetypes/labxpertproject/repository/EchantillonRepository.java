package org.apache.maven.archetypes.labxpertproject.repository;

import org.apache.maven.archetypes.labxpertproject.entitiy.model.Echantillon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EchantillonRepository extends JpaRepository<Echantillon, Long> {
}
