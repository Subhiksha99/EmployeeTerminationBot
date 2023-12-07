package com.example.mongoservice.service.flagsDb;

import com.example.mongoservice.dto.flagsDb.TerminationMail;
import com.example.mongoservice.exception.EmployeeFoundException;
import com.example.mongoservice.exception.EmployeeNotFoundException;
import com.example.mongoservice.model.flagsDb.Flags;
import com.example.mongoservice.repository.flagsDb.IFlagsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlagsServiceImpl implements IFlagsService {
    @Autowired
    private IFlagsRepository flagsRepo;
    @Autowired
    private JavaMailSender javaMailSender;
    @Override
    public List<Flags> getAllFlags() {
        return flagsRepo.findAll();
    }

    @Override
    public Flags getFlagsById(long empId) throws EmployeeNotFoundException {
        Optional<Flags> tempFlags=flagsRepo.findById(empId);
        if(tempFlags.isEmpty()){
            throw new EmployeeNotFoundException("Employee with the given id:"+empId+" does not exist");
        }
        return tempFlags.get();
    }

    @Override
    public Flags deleteFlagsById(long empId) throws EmployeeNotFoundException {
        Optional<Flags> tempFlags=flagsRepo.findById(empId);
        if(tempFlags.isEmpty()){
            throw new EmployeeNotFoundException("Employee with the given id:"+empId+" does not exist");
        }
        flagsRepo.deleteById(empId);
        return tempFlags.get();
    }

    @Override
    public Flags addFlags(Flags flags) throws EmployeeFoundException{
        long empId=flags.getEmployeeId();
        Optional<Flags> tempflags=flagsRepo.findById(empId);
        if(tempflags.isPresent()) {
            throw new EmployeeFoundException("Employee with the given id:" + empId + " already exists");
        }
        return flagsRepo.save(flags);
    }

    @Override
    public Flags updateFlags(Flags flags) throws EmployeeNotFoundException{
        long empId=flags.getEmployeeId();
        Optional<Flags> tempflags=flagsRepo.findById(empId);
        if(tempflags.isEmpty()) {
            throw new EmployeeNotFoundException("Employee with the given id:" + empId + " does not exist");
        }
        return flagsRepo.save(flags);
    }

    @Override
    public String sendMail(TerminationMail mailcontent) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(mailcontent.getEmail());
        msg.setSubject("Confirmation of Resignation Processing");
        msg.setText("Dear "+mailcontent.getName()+",\nI wanted to confirm that we have received and processed your resignation from Natwest.Your last working day will be on "+mailcontent.getTerminationDate()+".\nPlease let us know if there are any formalities or information you require during this transition. \nBest regards, \nHR Team");
        javaMailSender.send(msg);
        return "success";
    }

    @Override
    public String sendMailToCancelResign(TerminationMail mailcontent) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(mailcontent.getEmail());
        msg.setSubject("Rescinding the Termination - Welcome Back");
        msg.setText("Dear "+mailcontent.getName()+"\n We are pleased to inform you that the termination of your employment with Natwest, which was previously communicated, has been rescinded. After further review, we have decided to retain your service.\nPlease contact [HR Contact] for further details.\n We appreciate your understanding and look forward to your continued contributions to our team. \n Sincerely, \n HR Team");
        javaMailSender.send(msg);
        return "success";
    }
}
