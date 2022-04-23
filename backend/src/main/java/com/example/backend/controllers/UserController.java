package com.example.backend.controllers;

import com.example.backend.models.requests.UserDetailRequestModel;
import com.example.backend.models.responses.UserRest;
import com.example.backend.services.UserServiceInterface;
import com.example.backend.shared.dtos.UserDto;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Le decimos que es un controlador con la anotacion
@RestController
//Rutascon prefijo corriendo en el 8080
@RequestMapping("/users") //localhost:8080/users
public class UserController {

    @Autowired
    UserServiceInterface userService;
    
    @GetMapping
    public String getUser(){
        return "get user details";
    }
    //metodo o endpoint donde se reciben los datos del usuario como objt java
    @PostMapping
    public UserRest creatUsereUser(@RequestBody UserDetailRequestModel userDetails){
        //Se crea el objeto que se va a retornar
        UserRest userToReturn = new UserRest();
        // El DTO Data Transfer Object se puede usar en las distintas layers, se usara para enviar a la logica de la app
        UserDto userDto = new UserDto();
        //Clase de Spring dondo luego usamos el metodo que copia propiedades de un objeto a otro
        BeanUtils.copyProperties(userDetails, userDto);
        //se crea un objeto tipo DTO donde se hace uso de la función create userDto
        UserDto creatUserDto = userService.createUser(userDto);
        //Se copian las propiedades del objeto al objeto a retornar
        BeanUtils.copyProperties(creatUserDto, userToReturn);
        //Se retorna el objeto
        return userToReturn;

    }
}
