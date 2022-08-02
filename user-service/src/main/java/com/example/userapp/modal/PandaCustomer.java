package com.example.userapp.modal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PandaCustomer {
    private String name;
    private long id;
    private String email;
    private String phoneNo;
}
