package br.com.caelestis.api.resources.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.caelestis.api.services.exceptions.DataIntegrityViolationException;
import br.com.caelestis.api.services.exceptions.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e,
            HttpServletRequest request) {
        StandardError error = new StandardError(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<StandardError> dataIntegrityViolationException(
            DataIntegrityViolationException e, HttpServletRequest request) {
        StandardError error = new StandardError(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
