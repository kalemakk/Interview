package com.example.interview.services;

import com.example.interview.dtos.AcademicScriptRequest;
import com.example.interview.dtos.UpdateAcademicScriptRequest;
import com.example.interview.exceptions.AcademicScriptNotFound;
import com.example.interview.modals.OlevelScript;
import com.example.interview.repository.OlevelAcademicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class OlevelScriptService implements AcademicScript{

    private final OlevelAcademicRepository olevelAcademicRepository;

    public OlevelScript getOlevelScriptByCandidateNumber(String candidateNumber){
        return olevelAcademicRepository.findAlevelScriptByCandidateNumber(candidateNumber).orElseThrow(
                ()-> new AcademicScriptNotFound("Alevel Script Not Found")
        );
    }
    @Override
    public String createScript(AcademicScriptRequest academicScriptRequest) {

        OlevelScript olevelScript = new OlevelScript();
        olevelScript.setYear(academicScriptRequest.getYear());
        olevelScript.setCandidateName(academicScriptRequest.getCandidate_name());
        olevelScript.setCandidateNumber(academicScriptRequest.getCandidate_number());
        olevelScript.setSubjectCode(academicScriptRequest.getSubject_code());
        olevelScript.setRandomCode(generateRandomCode());
        olevelAcademicRepository.save(olevelScript);
        return "Olevel Script created successfully";
    }

    @Override
    public List<OlevelScript> getAllScripts() {
        return olevelAcademicRepository.findAll();
    }

    @Override
    public String updateScript(UpdateAcademicScriptRequest updateAcademicScriptRequest) {

        OlevelScript olevelScript = olevelAcademicRepository.findAlevelScriptByCandidateNumber(updateAcademicScriptRequest.candidate_number())
                .orElseThrow(
                        () -> new AcademicScriptNotFound("Alevel Script Not Found", HttpStatus.NOT_FOUND)
                );
        olevelScript.setYear(updateAcademicScriptRequest.year());
        olevelScript.setCandidateName(updateAcademicScriptRequest.candidate_name());
        olevelScript.setCandidateNumber(updateAcademicScriptRequest.candidate_number());
        olevelScript.setSubjectCode(updateAcademicScriptRequest.subject_code());

        olevelAcademicRepository.save(olevelScript);
        return "Olevel Script updated successfully";
    }

    @Override
    public String deleteScript(String candidateNumber) {

        OlevelScript olevelScript = olevelAcademicRepository.findAlevelScriptByCandidateNumber(candidateNumber).orElseThrow(
                () -> new AcademicScriptNotFound("Olevel Script Not Found", HttpStatus.NOT_FOUND)
        );

        olevelAcademicRepository.delete(olevelScript);
        return "Olevel Script deleted successfully";
    }

    @Override
    public String generateRandomCode() {
        Random random = new Random();
        return String.format("OL%s", random.nextInt(10000, 80000));
    }
}
