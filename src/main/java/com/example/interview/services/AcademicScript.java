package com.example.interview.services;

import com.example.interview.dtos.AcademicScriptRequest;
import com.example.interview.dtos.UpdateAcademicScriptRequest;

import java.util.List;

public interface AcademicScript {

    public String createScript(AcademicScriptRequest academicScriptRequest);

    public List<?> getAllScripts();

    public String updateScript(UpdateAcademicScriptRequest updateAcademicScriptRequest);

    public String deleteScript(String candidateNumber);

    public String generateRandomCode();


}
