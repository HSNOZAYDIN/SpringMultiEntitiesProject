package com.huseyinoz.exception;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    private List<String> addMapValue(List<String> list, String newValue) {
        list.add(newValue);
        return list;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleMethodNotValidException(MethodArgumentNotValidException ex) {

        Map<String, List<String>> errorsMap = new HashMap<>();

        for (ObjectError objError : ex.getBindingResult().getAllErrors()) {

            String fieldName;

            if (objError instanceof FieldError) {
                fieldName = ((FieldError) objError).getField();
            } else {
                fieldName = objError.getObjectName();
            }

            errorsMap
                .computeIfAbsent(fieldName, k -> new ArrayList<>())
                .add(objError.getDefaultMessage());
        }

        ApiError apiError = createApiError(errorsMap);
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }

    private ApiError createApiError(Map<String, List<String>> errors) {
        ApiError apiError = new ApiError();
        apiError.setId(UUID.randomUUID().toString());

        // java.sql.Date oluşturmanın DOĞRU yolu
        apiError.setErrorTime(new Date(System.currentTimeMillis()));

        apiError.setErrors(errors);
        return apiError;
    }
}
