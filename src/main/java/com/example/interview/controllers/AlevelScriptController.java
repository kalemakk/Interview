package com.example.interview.controllers;

import com.example.interview.dtos.AcademicScriptRequest;
import com.example.interview.dtos.UpdateAcademicScriptRequest;
import com.example.interview.modals.AlevelScript;
import com.example.interview.services.AlevelScriptService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/alevel-scripts")
@RequiredArgsConstructor
public class AlevelScriptController {

    private final AlevelScriptService alevelScriptService;

    @GetMapping
    ResponseEntity<?> allAlevelScripts(){
        List<AlevelScript> alevelScripts = alevelScriptService.getAllScripts();
        return ResponseEntity.ok(alevelScripts);
    }

    @GetMapping("/{candidateNumber}")
    ResponseEntity<?> getScriptByCandidateNumber(@PathVariable String candidateNumber){
        return ResponseEntity.ok(alevelScriptService.getAlevelScriptByCandidateNumber(candidateNumber));
    }

    @PostMapping
    ResponseEntity<?> createAlevelScript(@RequestBody AcademicScriptRequest academicScriptRequest){
        return ResponseEntity.ok(alevelScriptService.createScript(academicScriptRequest));
    }

    @PutMapping
    ResponseEntity<?> updateAlevelScript(@RequestBody UpdateAcademicScriptRequest updateAcademicScriptRequest){
        return ResponseEntity.ok(alevelScriptService.updateScript(updateAcademicScriptRequest));
    }

    @DeleteMapping("/{candidateNumber}")
    ResponseEntity<?> deleteAlevelScript(@PathVariable String candidateNumber){
        return ResponseEntity.ok(alevelScriptService.deleteScript(candidateNumber));
    }


}
