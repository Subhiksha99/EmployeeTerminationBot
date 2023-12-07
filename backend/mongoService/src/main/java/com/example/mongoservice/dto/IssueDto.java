package com.example.mongoservice.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class IssueDto {
    private long complaintId;
    private String description;
    private List<String> actions;

}
