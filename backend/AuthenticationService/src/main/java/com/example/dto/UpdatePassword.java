package com.example.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdatePassword {
 private String email;
 private String password;
 private String crmpassword;

}
