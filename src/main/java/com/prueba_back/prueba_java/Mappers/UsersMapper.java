package com.prueba_back.prueba_java.Mappers;

import com.prueba_back.prueba_java.Dto.UserDto;
import com.prueba_back.prueba_java.Entity.Users;
import com.prueba_back.prueba_java.Response.ResponseUserSave;
import com.prueba_back.prueba_java.Response.ResponseUsers;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UsersMapper {
    public ResponseUsers toResponseUserDto(List<Users> users, Integer codeResponse, String message, String status){
        return ResponseUsers.builder()
                .message(message)
                .codResponse(codeResponse)
                .status(status)
                .usersDto(toUser(users))
                .build();
    }

    public List<UserDto> toUser(List<Users> users){
        if (users != null && !users.isEmpty()){
            return users.stream().map(this::toUserMapp)
                    .collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    public UserDto toUserMapp(Users users){
        if (users != null){
            return UserDto.builder()
                    .name(users.getName())
                    .lastName(users.getLastname())
                    .age(users.getAge())
                    .addres(users.getAddres())
                    .identification(users.getIdentification())
                    .username(users.getUsername())
                    .phone(users.getPhone())
                    .build();
        }
        return null;
    }

    public ResponseUserSave toResponseUserSave(Users users, Integer codeResponse, String message, String status){
        return ResponseUserSave.builder()
                .codResponse(codeResponse)
                .message(message)
                .status(status)
                .usersDto(toUserSave(users))
                .build();
    }

    public UserDto toUserSave(Users users){
        UserDto userDto = new UserDto();

        if (users != null){
            userDto.name(users.getName());
            userDto.lastName(users.getLastname());
            userDto.username(users.getUsername());
            userDto.password(users.getPassword());
            userDto.age(users.getAge());
            userDto.phone(users.getPhone());
            userDto.addres(users.getAddres());
            userDto.identification(users.getIdentification());

            return userDto;
        }
        return null;
    }
}
