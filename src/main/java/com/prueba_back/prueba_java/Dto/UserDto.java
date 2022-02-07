package com.prueba_back.prueba_java.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("lastname")
    private String lastName;

    @JsonProperty("username")
    private String username;

    @JsonProperty("password")
    private String password;

    @JsonProperty("age")
    private Long age;

    @JsonProperty("phone")
    private BigInteger phone;

    @JsonProperty("addres")
    private String addres;

    @JsonProperty("identification")
    private String identification;



}
