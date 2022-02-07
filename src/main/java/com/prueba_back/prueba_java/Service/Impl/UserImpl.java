package com.prueba_back.prueba_java.Service.Impl;

import com.prueba_back.prueba_java.Dto.UserDto;
import com.prueba_back.prueba_java.Entity.Users;
import com.prueba_back.prueba_java.Mappers.UsersMapper;
import com.prueba_back.prueba_java.Repository.UserRepository;
import com.prueba_back.prueba_java.Response.ResponseProduct;
import com.prueba_back.prueba_java.Response.ResponseUsers;
import com.prueba_back.prueba_java.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UsersMapper usersMapper;

    private PasswordEncoder passwordEncoder;

    @Override
    public Users save(Users userDto) {
        if(userDto != null){
            Users users = userRepository.save(userDto);
            return users;
        }
        return null;
    }

    @Override
    public ResponseUsers listAll() {

        try{

            List<Users> users =  userRepository.findAll();
            return usersMapper.toResponseUserDto(users,200,"Lista de usuarios consultada exitosamente","200");
        }catch (Exception e){
            return ResponseUsers.builder()
                    .codResponse(400)
                    .message(e.toString())
                    .status("400")
                    .build();
        }

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
