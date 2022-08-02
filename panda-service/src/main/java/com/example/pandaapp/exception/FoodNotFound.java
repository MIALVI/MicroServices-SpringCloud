package com.example.pandaapp.exception;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FoodNotFound extends RuntimeException{

    private Integer code;
    private String message;
    private String detailedMessage;
}