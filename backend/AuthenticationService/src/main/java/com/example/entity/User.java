package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;


@Data
@Entity
public class User {
    @Id
    int corporate_id;
    String email;
    String password;
    LocalDate last_logged_in;
    Boolean first_logged_in;
}
