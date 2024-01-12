package org.apache.maven.archetypes.labxpertproject.entitiy.model;

import org.apache.maven.archetypes.labxpertproject.LabXpertProjectApplication;
import org.apache.maven.archetypes.labxpertproject.entitiy.enums.StatutDanalyse;
import org.apache.maven.archetypes.labxpertproject.entitiy.enums.StatutDeResultat;
import org.apache.maven.archetypes.labxpertproject.repository.AnalyseRepository;
import org.apache.maven.archetypes.labxpertproject.repository.SousAnalyseRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringJUnitConfig(LabXpertProjectApplication.class)
@SpringBootTest
class SousAnalyseTest {

    @Autowired
    SousAnalyseRepository sousAnalyseRepository;

    @Autowired
    AnalyseRepository analyseRepository;

    SousAnalyse testSousAnalyse;
    Analyse testAnalyse;

    @BeforeEach
    void setUp() {
        // Create an Analyse entity to associate with the SousAnalyse entity
        testAnalyse = new Analyse();
        testAnalyse.setDateDebutAnalyse(LocalDate.now());
        testAnalyse.setDateFinAnalyse(LocalDate.now().plusDays(7));
        testAnalyse.setEtatAnalyse(StatutDanalyse.EN_ATTENTE);
        testAnalyse.setCommentaire("Test Comment");
        testAnalyse = analyseRepository.save(testAnalyse);

        // Create a SousAnalyse entity to test
        testSousAnalyse = new SousAnalyse();
        testSousAnalyse.setResultat("Test Result");
        testSousAnalyse.setUniteDeMesure("Test Unit");
        testSousAnalyse.setStatutDeResultat(StatutDeResultat.NORMAL);
        testSousAnalyse.setAnalyse(testAnalyse);
        testSousAnalyse = sousAnalyseRepository.save(testSousAnalyse);
    }

    @Test
    void testCreateSousAnalyse() {
        SousAnalyse createdSousAnalyse = sousAnalyseRepository.findById(testSousAnalyse.getResultatId()).orElse(null);

        assertThat(createdSousAnalyse).isNotNull();
        assertThat(createdSousAnalyse.getResultat()).isEqualTo("Test Result");
    }

    @Test
    void testUpdateSousAnalyse() {
        SousAnalyse existingSousAnalyse = sousAnalyseRepository.findById(testSousAnalyse.getResultatId()).orElse(null);
        existingSousAnalyse.setResultat("Updated Result");

        sousAnalyseRepository.save(existingSousAnalyse);

        SousAnalyse updatedSousAnalyse = sousAnalyseRepository.findById(existingSousAnalyse.getResultatId()).orElse(null);

        assertThat(updatedSousAnalyse).isNotNull();
        assertThat(updatedSousAnalyse.getResultat()).isEqualTo("Updated Result");
    }

    @Test
    void testFindSousAnalyseById() {
        SousAnalyse foundSousAnalyse = sousAnalyseRepository.findById(testSousAnalyse.getResultatId()).orElse(null);

        assertThat(foundSousAnalyse).isNotNull();
        assertThat(foundSousAnalyse.getResultat()).isEqualTo("Test Result");
    }

    @Test
    void testDeleteSousAnalyse() {
        sousAnalyseRepository.deleteById(testSousAnalyse.getResultatId());

        SousAnalyse deletedSousAnalyse = sousAnalyseRepository.findById(testSousAnalyse.getResultatId()).orElse(null);
        assertThat(deletedSousAnalyse).isNull();
    }

    @AfterEach
    void tearDown() {
        if (sousAnalyseRepository.findById(testSousAnalyse.getResultatId()).orElse(null) != null)
            sousAnalyseRepository.deleteById(testSousAnalyse.getResultatId());
    }
}
