package com.prueba_back.prueba_java.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Users {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Lastname")
    private String lastname;

    @Column(name = "UserName")
    private String username;

    @Column(name = "Password")
    private String password;

    @Column(name = "Age")
    private Long age;

    @Column(name = "Phone")
    private BigInteger phone;

    @Column(name = "Addres")
    private String addres;

    @Column(name = "Identification")
    private String identification;

    @Column(name = "State")
    private boolean state;

}
