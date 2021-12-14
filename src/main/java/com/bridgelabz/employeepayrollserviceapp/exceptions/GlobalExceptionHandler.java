package com.bridgelabz.employeepayrollserviceapp.exceptions;

import com.bridgelabz.employeepayrollserviceapp.dto.ResponseDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,
                                                               HttpHeaders headers,
                                                               HttpStatus status, WebRequest request) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", new Date());
        body.put("Status", status.value());

        List<String> errors = exception.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(x -> x.getDefaultMessage())
                .collect(Collectors.toList());
        body.put("errors", errors);
        return new ResponseEntity<>(body, headers, status);
    }

    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<ResponseDTO> handleNotFoundException(DataNotFoundException notFoundException, WebRequest request) {
        ResponseDTO responseDTO = new ResponseDTO(notFoundException.getMessage(), request.getDescription(false), new Date());
        return new ResponseEntity<>(responseDTO, HttpStatus.NOT_FOUND);
    }

//    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
//    public ResponseEntity<ResponseDTO> handleConstraintViolationException(SQLIntegrityConstraintViolationException sqlIntegrityConstraintViolationException, WebRequest request) {
//        ResponseDTO responseDTO = new ResponseDTO(sqlIntegrityConstraintViolationException.getMessage(), request.getDescription(false), new Date());
//        return new ResponseEntity<>(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
//    }
}
