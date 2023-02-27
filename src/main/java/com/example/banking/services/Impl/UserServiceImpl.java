package com.example.banking.services.Impl;

import com.example.banking.exceptions.CustomException;

import com.example.banking.model.dto.UserDto;
import com.example.banking.model.entity.Account;
import com.example.banking.model.entity.User;
import com.example.banking.model.enums.UserStatus;
import com.example.banking.model.repository.UserRepository;
import com.example.banking.services.PasswordService;
import com.example.banking.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordService pwService;
    @Override
    public User validateUser(String username, String password) {
        User user = userRepository.findByUsername(username);
        System.out.println(user);
        if (user != null) {
            if (pwService.matches(password, user.getPassword())) {
                return user;
            }
        }
        return null;
    }
@Override
    public User findById(int id) {
        return userRepository.findById(id);
    }

@Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

}