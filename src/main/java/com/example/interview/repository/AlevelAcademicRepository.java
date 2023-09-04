package com.example.interview.repository;

import com.example.interview.modals.AlevelScript;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AlevelAcademicRepository extends JpaRepository<AlevelScript, Long> {

    Optional<AlevelScript> findAlevelScriptByCandidateNumber(String candidateNumber);

}
