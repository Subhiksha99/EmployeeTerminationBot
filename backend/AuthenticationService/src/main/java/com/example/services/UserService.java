package com.example.services;

import com.example.dto.LoginInputDto;
import com.example.dto.LoginRespDto;
import com.example.dto.UpdatePassword;
import com.example.entity.User;
import com.example.exception.InvalidCredentialException;
import com.example.exception.UserNotFoundException;
import com.example.repository.IUserRepository;
import com.example.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;

@Service
public class UserService implements IUserService{
    @Autowired
    IUserRepository userRepository;
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private JwtUtil jwtUtil;

    public String token;
    @Override
    public User getUserById(int id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public ResponseEntity<LoginRespDto> getUserById(LoginInputDto loginInput) throws Exception{
        Optional<User> userObj=userRepository.findById(loginInput.getCorporate_id());
        if(userObj.isPresent())
        {
            //user is present
            User newUser=userObj.get();
            if(newUser.getEmail().equals(loginInput.getEmail()) && newUser.getPassword().equals(loginInput.getPassword()))
            {
               //valid user
                LoginRespDto res=new LoginRespDto();
                res.setCorporate_id(loginInput.getCorporate_id());
                res.setEmail(loginInput.getEmail());
                res.setFirstTimeLoggedIn(newUser.getFirst_logged_in());
                token=jwtUtil.generateJwt(newUser);
                System.out.println(token);
                HttpHeaders headers = new HttpHeaders();
                headers.add("token",token);
                //return new ResponseEntity<>(res,headers, HttpStatus.OK);
                return ResponseEntity.ok()
                        .header("token", token)
                        .body(res);
            }
            else{
                //invalid credential
                throw new InvalidCredentialException("The email or password is not valid one");
            }
        }
        else{
            //use not found
            throw new UserNotFoundException("No User is found with the corporate id: "+loginInput.getCorporate_id());
        }

    }

    @Override
    public User changeUserPassword(UpdatePassword updatePwd) throws Exception{
        User obj=userRepository.findByEmail(updatePwd.getEmail());
        if(obj!=null)
        {   //jwtUtil.verify(auth);
            obj.setPassword(updatePwd.getPassword());
            obj.setFirst_logged_in(false);
            return userRepository.save(obj);
        }
        else {
           throw new UserNotFoundException("Invalid email ID");
        }
    }

    @Override
    public User sendEmail(LoginInputDto loginInput) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(loginInput.getEmail());
        msg.setSubject("Credential for Workforce Departure Companion Bot");
        msg.setText("Hello User! \n The cedential for using workforce departure bot is "+loginInput.getPassword()+".This is a one time password after login the application will prompt you to resent the password.Hope you will have a great experience with our bot. Thanks for contacting us");
        javaMailSender.send(msg);
        User obj=new User();
        obj.setCorporate_id(loginInput.getCorporate_id());
        obj.setEmail(loginInput.getEmail());
        obj.setPassword(loginInput.getPassword());
        obj.setFirst_logged_in(true);
        obj.setLast_logged_in(LocalDate.now());
        return userRepository.save(obj);
    }
}
