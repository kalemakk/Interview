package com.example.interview.controllers;

import com.example.interview.dtos.AcademicScriptRequest;
import com.example.interview.dtos.UpdateAcademicScriptRequest;
import com.example.interview.modals.OlevelScript;
import com.example.interview.services.OlevelScriptService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/olevel-scripts")
@RequiredArgsConstructor
public class OlevelScriptController {

    private final OlevelScriptService olevelScriptService;

    @GetMapping
    ResponseEntity<?> allAlevelScripts(){
        List<OlevelScript> olevelScripts = olevelScriptService.getAllScripts();
        return ResponseEntity.ok(olevelScripts);
    }

    @GetMapping("/{candidateNumber}")
    ResponseEntity<?> getScriptByCandidateNumber(@PathVariable String candidateNumber){
        return ResponseEntity.ok(olevelScriptService.getOlevelScriptByCandidateNumber(candidateNumber));
    }

    @PostMapping
    ResponseEntity<?> createOlevelScript(@RequestBody AcademicScriptRequest academicScriptRequest){
        return ResponseEntity.ok(olevelScriptService.createScript(academicScriptRequest));
    }

    @PutMapping
    ResponseEntity<?> updateOlevelScript(@RequestBody UpdateAcademicScriptRequest updateAcademicScriptRequest){
        return ResponseEntity.ok(olevelScriptService.updateScript(updateAcademicScriptRequest));
    }

    @DeleteMapping("/{candidateNumber}")
    ResponseEntity<?> deleteOlevelScript(@PathVariable String candidateNumber){
        return ResponseEntity.ok(olevelScriptService.deleteScript(candidateNumber));
    }

}
