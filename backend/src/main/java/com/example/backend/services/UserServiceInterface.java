package com.example.backend.services;

import com.example.backend.shared.dtos.UserDto;

public interface UserServiceInterface {
    //Se el metodo create user
    public UserDto createUser (UserDto user);
    
}
