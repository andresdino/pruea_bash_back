package com.prueba_back.prueba_java.Mappers;

import com.prueba_back.prueba_java.Dto.CarDto;
import com.prueba_back.prueba_java.Entity.Car;
import com.prueba_back.prueba_java.Response.ResponseCar;
import com.prueba_back.prueba_java.Response.ResponseCarSave;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarMapper {
    public ResponseCar toResponseCarDto(List<Car> cars,Integer codeResponse, String message, String status){
        return ResponseCar.builder()
                .message(message)
                .codResponse(codeResponse)
                .status(status)
                .carDto(toCar(cars))
                .build();
    }

    public List<CarDto> toCar(List<Car> cars){
        if (cars != null && !cars.isEmpty()){
            return cars.stream().map(this::toCarMap)
                    .collect(Collectors.toList());
        }

        return Collections.emptyList();
    }

    public CarDto toCarMap(Car car){
        if (car != null){
            return CarDto.builder()
                    .idProduct(car.getIdProduc().getId())
                    .idUser(car.getIdUser().getId())
                    .cantidad(car.getCantidad())
                    .build();
        }
        return null;
    }

    public ResponseCarSave toResponseCarSave(Car car, Integer codeResponse, String message, String status){
        return ResponseCarSave.builder()
                .codResponse(codeResponse)
                .message(message)
                .status(status)
                .carDto(toCarSave(car))
                .build();
    }

    public CarDto toCarSave(Car car){
        CarDto carDto = new CarDto();

        if (car != null){
            carDto.idProduct(car.getIdProduc().getId());
            carDto.idUser(car.getIdUser().getId());
            carDto.cantidad(car.getCantidad());

            return carDto;
        }
        return null;
    }
}
