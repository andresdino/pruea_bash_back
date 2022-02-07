package com.prueba_back.prueba_java.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "idCar")
    private Long id;

    @Column(name = "id")
    private Long idUser;

    @Column(name = "IDProducts")
    private Long idProduc;

    @Column(name = "cantidad")
    private Long cantidad;
}
