package com.prueba_back.prueba_java.Service;

import com.prueba_back.prueba_java.Dto.CarDto;
import com.prueba_back.prueba_java.Entity.Car;
import com.prueba_back.prueba_java.Response.ResponseCar;
import com.prueba_back.prueba_java.Response.ResponseCarSave;

import java.util.List;

public interface CarService {

    ResponseCarSave save(CarDto car);

    ResponseCar listAll();

    List<Car> listByUser(Long idUser);
}
