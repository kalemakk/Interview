package com.example.interview.repository;

import com.example.interview.modals.AlevelScript;
import com.example.interview.modals.OlevelScript;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OlevelAcademicRepository extends JpaRepository<OlevelScript, Long> {
    Optional<OlevelScript> findAlevelScriptByCandidateNumber(String candidateNumber);

}
