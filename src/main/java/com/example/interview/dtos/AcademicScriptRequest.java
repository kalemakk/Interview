package com.example.interview.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AcademicScriptRequest {
    private String candidate_name;
    private String candidate_number;
    private int year;
    private String subject_code;
}
