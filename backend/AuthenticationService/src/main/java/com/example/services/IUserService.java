package com.example.services;

import com.example.dto.LoginInputDto;
import com.example.dto.LoginRespDto;
import com.example.dto.UpdatePassword;
import com.example.entity.User;
import com.example.exception.UserNotFoundException;
import org.springframework.http.ResponseEntity;

public interface IUserService {
    public User getUserById(int id);
    public User addUser(User user);
    public ResponseEntity<LoginRespDto> getUserById(LoginInputDto loginInput) throws Exception;
    public User changeUserPassword(UpdatePassword updatePwd)throws Exception;

    public User sendEmail(LoginInputDto loginInput);
}
