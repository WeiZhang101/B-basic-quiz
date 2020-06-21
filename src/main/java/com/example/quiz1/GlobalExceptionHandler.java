package com.example.quiz1;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(UserNotFoundException.class)
  public ResponseEntity<ErrorResult> handle(UserNotFoundException ex) {
    String time = LocalDateTime.now().toString();
    Integer code = 400;
    ErrorResult errorResult = new ErrorResult(time, code, "Not Found", ex.getMessage());
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResult);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ErrorResult> handle(MethodArgumentNotValidException ex) {

    String time = LocalDateTime.now().toString();
    String message = ex.getBindingResult().getFieldError().getDefaultMessage();
    Integer code = 400;
    ErrorResult errorResult = new ErrorResult(time, code, "Bad Request", message);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResult);
  }

  @ExceptionHandler(ConstraintViolationException.class)
  public ResponseEntity<ErrorResult> handle(ConstraintViolationException ex) {
    Set<ConstraintViolation<?>> violations = ex.getConstraintViolations();

    String message = "";
    for (ConstraintViolation<?> constraint : ex.getConstraintViolations()) {
      message = constraint.getMessage();
      break;
    }
    String time = LocalDateTime.now().toString();
    Integer code = 400;
    ErrorResult errorResult = new ErrorResult(time, code, "Bad Request", message);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResult);
  }
}
