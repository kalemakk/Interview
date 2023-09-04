package com.example.interview.modals;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "alevel_script")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AlevelScript {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long id;
    private String candidateName;
    private String candidateNumber;
    private int year;
    private String randomCode;
    private String subjectCode;

}
