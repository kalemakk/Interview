package com.example.interview.exceptions.helper;

import com.example.interview.exceptions.AcademicScriptNotFound;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class ExceptionHandler {
    @ResponseBody
    ResponseEntity<JsonError> handleException(HttpServletRequest req, RuntimeException e) {

            if (e instanceof AcademicScriptNotFound) {
                AcademicScriptNotFound exception = (AcademicScriptNotFound) e;
                return new ResponseEntity<>(new JsonError(exception.getMessage()), exception.getHttpStatus());
            }

            return new ResponseEntity<>(new JsonError(e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
}
