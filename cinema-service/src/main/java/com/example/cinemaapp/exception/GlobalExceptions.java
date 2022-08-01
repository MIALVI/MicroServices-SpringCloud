package com.example.cinemaapp.exception;

import com.example.cinemaapp.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptions {
    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<ErrorDTO> handleServiceException(ServiceException ex){
        ErrorDTO errorDto = ErrorDTO.builder()
                .code(ex.getCode())
                .message(ex.getMessage())
                .detailedMessage(ex.getDetailedMessage())
                .build();
        return new ResponseEntity<>(errorDto, HttpStatus.valueOf(errorDto.getCode()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorDTO>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
        List<ErrorDTO> errorDtoList = ex.getBindingResult().getAllErrors().stream()
                .map(error -> ErrorDTO.builder()
                        .code(HttpStatus.BAD_REQUEST.value())
                        .message(error.getDefaultMessage())
                        .detailedMessage(error.getDefaultMessage())
                        .build())
                .collect(Collectors.toList());
        return new ResponseEntity<>(errorDtoList, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CustomerNotFound.class)
    public ResponseEntity<List<ErrorDTO>> handleCustomerNotFoundException(MethodArgumentNotValidException ex){
        List<ErrorDTO> errorDtoList = ex.getBindingResult().getAllErrors().stream()
                .map(error -> ErrorDTO.builder()
                        .code(HttpStatus.NOT_FOUND.value())
                        .message(error.getDefaultMessage())
                        .detailedMessage(error.getDefaultMessage())
                        .build())
                .collect(Collectors.toList());
        return new ResponseEntity<>(errorDtoList, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MovieNotFound.class)
    public ResponseEntity<List<ErrorDTO>> handleMovieNotFound(MethodArgumentNotValidException ex){
        List<ErrorDTO> errorDtoList = ex.getBindingResult().getAllErrors().stream()
                .map(error -> ErrorDTO.builder()
                        .code(HttpStatus.NOT_FOUND.value())
                        .message(error.getDefaultMessage())
                        .detailedMessage(error.getDefaultMessage())
                        .build())
                .collect(Collectors.toList());
        return new ResponseEntity<>(errorDtoList, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> handleException(Exception ex){
        ErrorDTO errorDto = ErrorDTO.builder()
                .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message(HttpStatus.INTERNAL_SERVER_ERROR.toString())
                .detailedMessage(ex.getMessage())
                .build();
        return new ResponseEntity<>(errorDto, HttpStatus.valueOf(errorDto.getCode()));
    }

}
