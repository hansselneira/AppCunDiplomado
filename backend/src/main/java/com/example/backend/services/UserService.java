package com.example.backend.services;

import java.util.ArrayList;
import java.util.UUID;

import com.example.backend.UserRepository;
import com.example.backend.entities.UserEntity;
import com.example.backend.shared.dtos.UserDto;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserServiceInterface {

    //se llama la clase que permite trabajar operaciones CRUD, interfaz
    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    //metodo para crear un usuario
    @Override
    public UserDto createUser(UserDto user) {

        //Validamos un correo
        if (userRepository.findByEmail(user.getEmail()) != null) 
            throw new RuntimeException("El correo electronico ya existe");
        //creamos objeto de la clase user entity
        UserEntity userEntity = new UserEntity();
        //se usa el metodo estatico para copiar target, source
        BeanUtils.copyProperties(user, userEntity);

        //Estos datos no se envian
        userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        // se genera de manera aleatoria el ID
        UUID userId = UUID.randomUUID();
        userEntity.setUserId(userId.toString());

        //entidad que queremos guardar en la base de datos;
        UserEntity storedUserDetails = userRepository.save(userEntity);
        

        UserDto userToReturn = new UserDto();
        BeanUtils.copyProperties(storedUserDetails, userToReturn);

        return userToReturn;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByEmail(email);

        if (userEntity == null){
            throw new UsernameNotFoundException(email);
        }
        return new User(userEntity.getEmail(), userEntity.getEncryptedPassword(), new ArrayList<>());
    }
    
}
