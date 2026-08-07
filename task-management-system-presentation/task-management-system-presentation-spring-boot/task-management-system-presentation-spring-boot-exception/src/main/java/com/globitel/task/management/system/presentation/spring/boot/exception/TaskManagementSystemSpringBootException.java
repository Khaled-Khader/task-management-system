package com.globitel.task.management.system.presentation.spring.boot.exception;

import com.globitel.task.management.system.core.shared.exception.*;
import com.globitel.task.management.system.core.shared.exception.data.ErrorMessage;
import com.globitel.task.management.system.presentation.spring.boot.exception.response.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.List;

@RestControllerAdvice
public class TaskManagementSystemSpringBootException {
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<List<ExceptionResponse>> handleBadRequestException(BadRequestException exception) {
        List<ErrorMessage> errorMessages = exception.getErrors();
        List<ExceptionResponse> list = errorMessages
                .stream()
                .map(errorMessage -> new ExceptionResponse(
                        errorMessage.getMessage(),
                        errorMessage.getCode(),
                        Instant.now()))
                .toList();
        return ResponseEntity
                .badRequest()
                .body(list);
    }


    @ExceptionHandler(NotAcceptableException.class)
    public ResponseEntity<ExceptionResponse> exception(NotAcceptableException exception) {
        return new ResponseEntity<>(
                new ExceptionResponse(
                        exception.getError().getMessage(),
                        exception.getError().getCode(),
                        Instant.now()
                ),
                HttpStatus.NOT_ACCEPTABLE
        );
    }

    @ExceptionHandler(InvalidConfigurationException.class)
    public ResponseEntity<ExceptionResponse> exception(InvalidConfigurationException exception) {
        return new ResponseEntity<>(
                new ExceptionResponse(
                        exception.getError().getMessage(),
                        exception.getError().getCode(),
                        Instant.now()
                ),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(UnAuthorizedException.class)
    public ResponseEntity<ExceptionResponse> exception(UnAuthorizedException exception) {
        return new ResponseEntity<>(
                new ExceptionResponse(
                        exception.getError().getMessage(),
                        exception.getError().getCode(),
                        Instant.now()
                ),
                HttpStatus.UNAUTHORIZED
        );
    }

    @ExceptionHandler(ServerInternalError.class)
    public ResponseEntity<ExceptionResponse> exception(ServerInternalError exception) {
        return new ResponseEntity<>(
                new ExceptionResponse(
                        exception.getError().getMessage(),
                        exception.getError().getCode(),
                        Instant.now()
                ),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<ExceptionResponse> exception(ApplicationException exception) {
        return new ResponseEntity<>(
                new ExceptionResponse(
                        exception.getError().getMessage(),
                        exception.getError().getCode(),
                        Instant.now()
                ),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}
