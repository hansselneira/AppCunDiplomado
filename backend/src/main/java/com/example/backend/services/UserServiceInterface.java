package com.example.backend.services;

import com.example.backend.shared.dtos.UserDto;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserServiceInterface extends UserDetailsService{
    //Se el metodo create user
    public UserDto createUser (UserDto user);
    
}
