package com.jms.guardiaoDoMarAPI.Response;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseModel> handleException(Exception ex) {
        return ResponseEntity.badRequest().body(new ResponseModel(ex.getMessage()));
    }
}
