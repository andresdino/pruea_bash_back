package com.prueba_back.prueba_java.Service;

import com.prueba_back.prueba_java.Entity.Car;

import java.util.List;

public interface CarService {

    Car save(Car car);

    List<Car> listAll();

    List<Car> listByUser(Long idUser);
}
