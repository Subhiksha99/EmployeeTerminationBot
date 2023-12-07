package com.example.mongoservice.model.transfersDb;

import com.example.mongoservice.model.possessionsDb.Possession;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "transfers")
@Getter
@Setter
public class Transfers {
    @Id
    private long employeeId;
    private List<Possession> possessionsList;
}
