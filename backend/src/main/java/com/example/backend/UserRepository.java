package com.example.backend;

import com.example.backend.entities.UserEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//Se utiliza para hacer operaciones CRUD, usando la clase CrudRepository
@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
    //public UserEntity findUserByEmailFirstName(String email);
}
