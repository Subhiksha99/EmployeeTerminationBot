package com.example.controller;

import com.example.dto.LoginInputDto;
import com.example.dto.LoginRespDto;
import com.example.dto.UpdatePassword;
import com.example.entity.User;
import com.example.exception.UserNotFoundException;
import com.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173/",exposedHeaders = "token")
@RestController
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable("id") int id) {
        return  userService.getUserById(id);
    }

    @PostMapping("/user/add")
    public User addUser(User user){
        return userService.addUser(user);
    }

    @PostMapping("/user/sendmail")
    public User sendMail(@RequestBody LoginInputDto loginInput){
        return userService.sendEmail(loginInput);
    }

    @PostMapping("/user/login")
    public ResponseEntity<LoginRespDto> getUserById(@RequestBody LoginInputDto loginInput) throws Exception{
        ResponseEntity<LoginRespDto> res=userService.getUserById(loginInput);
        return res;
    }

    @PatchMapping("/user/update/password")
    public User changeUserPassword(@RequestBody UpdatePassword updatePassword)throws Exception {
            return userService.changeUserPassword(updatePassword);
    }
}
