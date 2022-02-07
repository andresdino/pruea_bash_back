package com.prueba_back.prueba_java.Service.Impl;

import com.prueba_back.prueba_java.Entity.Car;
import com.prueba_back.prueba_java.Repository.CarsRepository;
import com.prueba_back.prueba_java.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarImpl implements CarService {

    @Autowired
    CarsRepository carRepository;

    @Override
    public Car save(Car car) {
        if(car != null){
            Car car1 = carRepository.save(car);
            return car1;
        }
        return null;
    }

    @Override
    public List<Car> listAll() {
        List<Car> cars = carRepository.findAll();
        return cars;
    }

    @Override
    public List<Car> listByUser(Long idUser) {
        List<Car> cars = carRepository.findByIdUser(idUser);
        return cars;
    }
}
