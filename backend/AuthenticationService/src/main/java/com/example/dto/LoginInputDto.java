package com.example.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginInputDto {
    int corporate_id;
    String email;
    String password;
}
