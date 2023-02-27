package com.example.banking.services;

import com.example.banking.model.dto.UserDto;
import com.example.banking.model.entity.Account;
import com.example.banking.model.entity.User;
import com.example.banking.services.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    public User validateUser(String username, String password);

    public User findById(int id);

    public User findByUsername(String username);
}
