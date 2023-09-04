package com.example.interview.exceptions;

import org.springframework.http.HttpStatus;

public class AcademicScriptNotFound extends RuntimeException{

    private HttpStatus httpStatus;
    public AcademicScriptNotFound(String message, HttpStatus httpStatus){
        super(message);
        this.httpStatus = httpStatus;
    }

    public AcademicScriptNotFound(String message){
        super(message);
    }

    public HttpStatus getHttpStatus(){
        return httpStatus;
    }
}
