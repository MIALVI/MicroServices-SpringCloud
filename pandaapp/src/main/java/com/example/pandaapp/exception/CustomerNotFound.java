package com.example.pandaapp.exception;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerNotFound extends RuntimeException {

    private Integer code;
    private String message;
    private String detailedMessage;
}