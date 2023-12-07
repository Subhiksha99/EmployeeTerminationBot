package com.example.mongoservice.dto.flagsDb;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class TerminationMail {
    private String name;
    private Date terminationDate;
    private String email;
}
