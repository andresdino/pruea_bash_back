package com.prueba_back.prueba_java.Service;

import com.prueba_back.prueba_java.Dto.UserDto;
import com.prueba_back.prueba_java.Entity.Users;

import java.util.List;


public interface UserService {

    public Users save(Users userDto);

    public List<Users> listAll();

    public UserDto listById(Long id);

    public UserDto update(Long id, UserDto userDto);

}
