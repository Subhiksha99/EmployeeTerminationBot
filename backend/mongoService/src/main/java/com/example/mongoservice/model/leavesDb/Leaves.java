package com.example.mongoservice.model.leavesDb;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@Document(collection = "leaves")
public class Leaves {
    @Id
    private int employeeId;
    private List<Leave> leavesList;
}
