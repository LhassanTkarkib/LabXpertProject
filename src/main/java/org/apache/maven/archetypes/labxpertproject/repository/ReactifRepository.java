package org.apache.maven.archetypes.labxpertproject.repository;

import org.apache.maven.archetypes.labxpertproject.entitiy.model.Reactif;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReactifRepository extends JpaRepository<Reactif, Long> {
}
