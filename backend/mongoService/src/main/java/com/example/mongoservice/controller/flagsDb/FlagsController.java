package com.example.mongoservice.controller.flagsDb;

import com.example.mongoservice.dto.flagsDb.TerminationMail;
import com.example.mongoservice.exception.EmployeeFoundException;
import com.example.mongoservice.exception.EmployeeNotFoundException;
import com.example.mongoservice.model.flagsDb.Flags;
import com.example.mongoservice.service.flagsDb.IFlagsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173/",exposedHeaders = "token")
@RestController
public class FlagsController {
    @Autowired
    private IFlagsService flagsService;

    @GetMapping("/flags/all")
    public ResponseEntity<List<Flags>> getAllFlags(){
        return new ResponseEntity<>(flagsService.getAllFlags(), HttpStatus.OK);
    }

    @GetMapping("/flags/getById")
    public ResponseEntity<Flags> getFlagsById(@RequestParam("id") long empId) throws EmployeeNotFoundException {
        return new ResponseEntity<>(flagsService.getFlagsById(empId), HttpStatus.OK);
    }

    @DeleteMapping("/flags/deleteById/{id}")
    public ResponseEntity<Flags> deleteFlagsById(@PathVariable("id") long empId) throws EmployeeNotFoundException {
        return new ResponseEntity<>(flagsService.deleteFlagsById(empId), HttpStatus.OK);
    }

    @PostMapping("/flags/add")
    public ResponseEntity<Flags> addFlags(@RequestBody Flags flags) throws EmployeeFoundException {
        return new ResponseEntity<>(flagsService.addFlags(flags), HttpStatus.OK);
    }

    @PutMapping("/flags/update")
    public ResponseEntity<Flags> updateFlags(@RequestBody Flags flags) throws EmployeeNotFoundException {
        return new ResponseEntity<>(flagsService.updateFlags(flags), HttpStatus.OK);
    }

    //send mail
    @PostMapping("/flags/sendmail")
    public String sendMail(@RequestBody TerminationMail mailcontent){
        return flagsService.sendMail(mailcontent);
    }

    @PostMapping("/flags/sendmail/cancel")
    public String sendMailToCancelResign(@RequestBody TerminationMail mailcontent){
        return flagsService.sendMailToCancelResign(mailcontent);
    }

}
