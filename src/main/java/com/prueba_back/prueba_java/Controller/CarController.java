package com.prueba_back.prueba_java.Controller;

import com.prueba_back.prueba_java.Entity.Car;
import com.prueba_back.prueba_java.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Car> ListProducts()throws IOException {
        return carService.listAll();
    }

    @PostMapping(value = "/save")
    public Car CarsSave(@RequestBody Car car){

        return this.carService.save(car);
    }

    @GetMapping(value = "/listByUser/{idUser}")
    public List<Car> carsByUser(@PathVariable Long idUser){
        return this.carService.listByUser(idUser);
    }

}
