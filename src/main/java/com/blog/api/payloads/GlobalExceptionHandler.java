package com.blog.api.payloads;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundExceptiuon.class)
public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(ResourceNotFoundExceptiuon ex){

        String message = ex.getMessage();
        ApiResponse apiResponse = new ApiResponse(message,false);

        return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.NOT_FOUND);

        }


        @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String ,String>> handleMethodArgNotValidException(MethodArgumentNotValidException ex){
            Map<String ,String> resp = new HashMap<>();

            ex.getBindingResult().getAllErrors().forEach((objectError -> {
                String fieldName = ((FieldError)objectError).getField();
              String errorMessage =   objectError.getDefaultMessage();
              resp.put(fieldName,errorMessage);
            }));

            return new ResponseEntity<Map<String ,String>>(resp,HttpStatus.BAD_REQUEST);
        }

}
