package com.prueba_back.prueba_java.Service;

import com.prueba_back.prueba_java.Dto.UserDto;
import com.prueba_back.prueba_java.Entity.Users;
import com.prueba_back.prueba_java.Response.ResponseUserSave;
import com.prueba_back.prueba_java.Response.ResponseUsers;

import java.util.List;


public interface UserService {

    public ResponseUserSave save(UserDto userDto);

    public ResponseUsers listAll();

    public UserDto listById(Long id);

    public UserDto update(Long id, UserDto userDto);

}
