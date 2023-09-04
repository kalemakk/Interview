package com.example.interview.exceptions.helper;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JsonError {
    private String message;
}
