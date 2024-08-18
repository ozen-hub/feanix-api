package com.feanix.system.advisers;

import com.feanix.system.exception.DuplicateEntryException;
import com.feanix.system.exception.EntryNotFoundException;
import com.feanix.system.util.StandardResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppWideExceptionHandler {

    @ExceptionHandler(DuplicateEntryException.class)
    public ResponseEntity<StandardResponseDto> handleDuplicateEntryException(
            DuplicateEntryException e
    ) {
        return new ResponseEntity<>(
                new StandardResponseDto(409, e.getMessage(), null),
                HttpStatus.CONFLICT
        );
    }

    @ExceptionHandler(EntryNotFoundException.class)
    public ResponseEntity<StandardResponseDto> handleEntryNotFoundException(
            EntryNotFoundException e
    ) {
        return new ResponseEntity<>(
                new StandardResponseDto(404, e.getMessage(), null),
                HttpStatus.NOT_FOUND
        );
    }
}
