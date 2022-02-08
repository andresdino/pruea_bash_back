package com.prueba_back.prueba_java.Service.Impl;

import com.prueba_back.prueba_java.Dto.UserDto;
import com.prueba_back.prueba_java.Entity.Users;
import com.prueba_back.prueba_java.Mappers.UsersMapper;
import com.prueba_back.prueba_java.Repository.UserRepository;
import com.prueba_back.prueba_java.Response.ResponseUserSave;
import com.prueba_back.prueba_java.Response.ResponseUsers;
import com.prueba_back.prueba_java.Service.UserService;
import com.prueba_back.prueba_java.Utils.EncriptarDesencriptar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UsersMapper usersMapper;


    @Override
    public ResponseUserSave save(UserDto userDto) {

        try{

            String PasswordEncryp = EncriptarDesencriptar.Encriptar(userDto.password());

            Users users = new Users();

            if(userDto != null){
                users.setName(userDto.name());
                users.setLastname(userDto.lastName());
                users.setUsername(userDto.username());
                users.setPassword(PasswordEncryp);
                users.setAge(userDto.age());
                users.setPhone(userDto.phone());
                users.setAddres(userDto.addres());
                users.setIdentification(userDto.identification());
                userRepository.save(users);
                users.setPassword("");
                return usersMapper.toResponseUserSave(users,201,"Usuario Creado con Exitosamente","201");
            }
            return usersMapper.toResponseUserSave(null,201,"Fallo al crear el usuario","201");
        }catch (Exception e){
            return usersMapper.toResponseUserSave(null, 400, e.toString(),
                    "400");
        }


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
