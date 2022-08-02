package com.example.centerapp.exceptions;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieNotFound extends RuntimeException {

    private Integer code;
    private String message;
    private String detailedMessage;
}