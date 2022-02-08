package com.prueba_back.prueba_java.Controller;

import com.prueba_back.prueba_java.Dto.UserDto;
import com.prueba_back.prueba_java.Entity.Users;
import com.prueba_back.prueba_java.Response.ResponseUserSave;
import com.prueba_back.prueba_java.Response.ResponseUsers;
import com.prueba_back.prueba_java.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
@CrossOrigin(origins = "*")
public class UserController {


    @Autowired
    private UserService userService;

    @GetMapping(value = "/list")
    public ResponseEntity<ResponseUsers> listUsers(){

        return new ResponseEntity<ResponseUsers>(userService.listAll(), HttpStatus.OK);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<ResponseUserSave> usersSave(@RequestBody UserDto users){
        return new ResponseEntity<ResponseUserSave>(userService.save(users),HttpStatus.CREATED);
    }
}
