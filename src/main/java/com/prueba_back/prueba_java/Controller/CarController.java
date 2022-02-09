package com.prueba_back.prueba_java.Controller;

import com.prueba_back.prueba_java.Dto.CarDto;
import com.prueba_back.prueba_java.Entity.Car;
import com.prueba_back.prueba_java.Response.ResponseCar;
import com.prueba_back.prueba_java.Response.ResponseCarSave;
import com.prueba_back.prueba_java.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("car")
@CrossOrigin(origins = "*")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping(value = "/list")
    public ResponseEntity<ResponseCar> ListProducts()throws IOException {
        return new ResponseEntity<ResponseCar>(carService.listAll(), HttpStatus.OK);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<ResponseCarSave> CarsSave(@RequestBody CarDto car){

        return new ResponseEntity<ResponseCarSave>(carService.save(car),HttpStatus.CREATED);
    }

    @GetMapping(value = "/listByUser/{idUser}")
    public List<Car> carsByUser(@PathVariable Long idUser){
        return this.carService.listByUser(idUser);
    }

}
