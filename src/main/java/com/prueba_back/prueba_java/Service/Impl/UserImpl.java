package com.prueba_back.prueba_java.Service.Impl;

import com.prueba_back.prueba_java.Dto.UserDto;
import com.prueba_back.prueba_java.Entity.Users;
import com.prueba_back.prueba_java.Repository.UserRepository;
import com.prueba_back.prueba_java.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public Users save(Users userDto) {
        if(userDto != null){
            Users users = userRepository.save(userDto);
            return users;
        }
        return null;
    }

    @Override
    public List<Users> listAll() {
        List<Users> users =  userRepository.findAll();
        return users;
    }

    @Override
    public UserDto listById(Long id) {
        return null;
    }

    @Override
    public UserDto update(Long id, UserDto userDto) {
        return null;
    }
}
