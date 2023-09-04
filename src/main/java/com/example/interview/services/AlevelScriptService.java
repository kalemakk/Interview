package com.example.interview.services;

import com.example.interview.dtos.AcademicScriptRequest;
import com.example.interview.dtos.UpdateAcademicScriptRequest;
import com.example.interview.exceptions.AcademicScriptNotFound;
import com.example.interview.modals.AlevelScript;
import com.example.interview.repository.AlevelAcademicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class AlevelScriptService implements AcademicScript{

    private final AlevelAcademicRepository alevelAcademicRepository;

    public AlevelScript getAlevelScriptByCandidateNumber(String candidateNumber){
        return alevelAcademicRepository.findAlevelScriptByCandidateNumber(candidateNumber).orElseThrow(
                ()-> new AcademicScriptNotFound("Alevel Script Not Found")
        );
    }

    @Override
    public String createScript(AcademicScriptRequest academicScriptRequest) {

        AlevelScript alevelScript = new AlevelScript();
        alevelScript.setYear(academicScriptRequest.getYear());
        alevelScript.setCandidateName(academicScriptRequest.getCandidate_name());
        alevelScript.setCandidateNumber(academicScriptRequest.getCandidate_number());
        alevelScript.setSubjectCode(academicScriptRequest.getSubject_code());
        alevelScript.setRandomCode(generateRandomCode());
        alevelAcademicRepository.save(alevelScript);
        return "Alevel Script created successfully";
    }

    @Override
    public List<AlevelScript> getAllScripts() {
        return alevelAcademicRepository.findAll();
    }

    @Override
    public String updateScript(UpdateAcademicScriptRequest updateAcademicScriptRequest) {

        AlevelScript alevelScript = alevelAcademicRepository.findAlevelScriptByCandidateNumber(updateAcademicScriptRequest.candidate_number())
                .orElseThrow(
                        () -> new AcademicScriptNotFound("Alevel Script Not Found", HttpStatus.NOT_FOUND)
                );

        alevelScript.setYear(updateAcademicScriptRequest.year());
        alevelScript.setCandidateName(updateAcademicScriptRequest.candidate_name());
        alevelScript.setCandidateNumber(updateAcademicScriptRequest.candidate_number());
        alevelScript.setSubjectCode(updateAcademicScriptRequest.subject_code());

        alevelAcademicRepository.save(alevelScript);
        return "Alevel Script updated successfully";
    }

    @Override
    public String deleteScript(String candidateNumber) {

        AlevelScript alevelScript = alevelAcademicRepository.findAlevelScriptByCandidateNumber(candidateNumber)
                .orElseThrow(
                        () -> new AcademicScriptNotFound("Alevel Script Not Found", HttpStatus.NOT_FOUND)
                );

        alevelAcademicRepository.delete(alevelScript);
        return "Alevel Script deleted successfully";
    }

    @Override
    public String generateRandomCode(){
        Random random = new Random();
        return String.format("AL%s",random.nextInt(10000, 80000));
    }

}
