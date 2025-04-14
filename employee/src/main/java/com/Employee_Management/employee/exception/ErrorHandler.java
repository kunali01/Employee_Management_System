package com.Employee_Management.employee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

public class ErrorHandler {
   @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<String> handleEmpNotFound(EmployeeNotFoundException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidation(MethodArgumentNotValidException e)
    {
        Map<String, String> er = new HashMap<>();
       e.getBindingResult().getFieldErrors().forEach(err->{
           er.put(err.getField(),err.getDefaultMessage());
       });
       return new ResponseEntity<>(er, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleOtherEx(Exception e){
        return new ResponseEntity<>("Something went wrong"+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
