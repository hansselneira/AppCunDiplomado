package com.example.backend.services;

import com.example.backend.UserRepository;
import com.example.backend.entities.UserEntity;
import com.example.backend.shared.dtos.UserDto;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserServiceInterface {

    //se llama la clase que permite trabajar operaciones CRUD, interfaz
    @Autowired
    UserRepository userRepository;

    //metodo para crear un usuario
    @Override
    public UserDto createUser(UserDto user) {
        
        //creamos objeto de la clase user entity
        UserEntity userEntity = new UserEntity();
        //se usa el metodo estatico para copiar target, source
        BeanUtils.copyProperties(user, userEntity);

        //Estos datos no se envian
        userEntity.setEncryptedPassword("password encriiptado");
        userEntity.setUserId("ID Publico");

        //entidad que queremos guardar en la base de datos;
        UserEntity storedUserDetails = userRepository.save(userEntity);
        

        UserDto userToReturn = new UserDto();
        BeanUtils.copyProperties(storedUserDetails, userToReturn);

        return userToReturn;
    }
    
}
