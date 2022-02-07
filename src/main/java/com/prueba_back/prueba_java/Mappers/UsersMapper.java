package com.prueba_back.prueba_java.Mappers;

import com.prueba_back.prueba_java.Dto.UserDto;
import com.prueba_back.prueba_java.Entity.Users;
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
                    .password(users.getPassword())
                    .username(users.getUsername())
                    .phone(users.getPhone())
                    .build();
        }
        return null;
    }
}
