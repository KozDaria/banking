package com.example.banking.services;

import com.example.banking.model.dto.UserDto;
import com.example.banking.model.entity.User;

public interface UserService {

    public UserDto create(UserDto userDto);
    public User validateUser(String username, String password);

    public User findById(int id);

    public User findByUsername(String username);
}
