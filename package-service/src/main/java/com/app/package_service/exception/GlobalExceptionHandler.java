package com.app.package_service.exception;

import com.app.package_service.payload.ErrorResponse;
import org.springframework.http.*;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleAnyException(
            Exception ex,
            WebRequest webRequest
    ) {
        ErrorResponse errorDetails = new ErrorResponse(new Date(), ex.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ErrorResponse> handleGloBazaarApiException(
            ApiException ex,
            WebRequest webRequest
    ) {
        ErrorResponse errorDetails = new ErrorResponse(new Date(), ex.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatusCode status,
            WebRequest request
    ) {
        Map<String,String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(
                (error)->{
                    String field = ((FieldError) error).getField();
                    String message = error.getDefaultMessage();
                    errors.put(field,message);
                }
        );
        return new ResponseEntity(errors,HttpStatus.BAD_REQUEST);
    }

}
