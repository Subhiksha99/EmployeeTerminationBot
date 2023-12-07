package com.example.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRespDto {
    int corporate_id;
    String email;
    Boolean firstTimeLoggedIn;
}
