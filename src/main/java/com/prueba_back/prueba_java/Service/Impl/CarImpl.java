package com.prueba_back.prueba_java.Service.Impl;

import com.prueba_back.prueba_java.Dto.CarDto;
import com.prueba_back.prueba_java.Entity.Car;
import com.prueba_back.prueba_java.Entity.Products;
import com.prueba_back.prueba_java.Mappers.CarMapper;
import com.prueba_back.prueba_java.Repository.CarsRepository;
import com.prueba_back.prueba_java.Repository.ProductRepository;
import com.prueba_back.prueba_java.Response.ResponseCar;
import com.prueba_back.prueba_java.Response.ResponseCarSave;
import com.prueba_back.prueba_java.Response.ResponseUsers;
import com.prueba_back.prueba_java.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarImpl implements CarService {

    @Autowired
    CarsRepository carRepository;

    @Autowired
    CarMapper carMapper;

    @Autowired
    ProductRepository productRepository;


    @Override
    public ResponseCarSave save(CarDto car) {
        try{
            Car car1 = new Car();
            if (car.idProduct() != null){
                Products products = productRepository.findByIdProduc(car.idProduct());
                if (products != null){
                    if (car.cantidad() > products.getQuantity()){
                        return carMapper.toResponseCarSave(null,400,"No se puede comprar mas productos de los que hay en existencia","400");
                    }
                    if (car.cantidad() < products.getQuantity()){
                        /*productRepository.deleteById(products.getId());*/
                        Products products1 = new Products();

                        Long newQuantity = products.getQuantity() - car.cantidad();

                        products1.setId(products.getId());
                        products1.setName(products.getName());
                        products1.setValue(products.getValue());
                        products1.setWeight(products.getWeight());
                        products1.setQuantity(newQuantity);
                        productRepository.save(products1);
                    }
                }
            }


            if(car != null){
                car1.setCantidad(car.cantidad());
                car1.setIdProduc(car.idProduct());
                car1.setIdUser(car.idUser());
                carRepository.save(car1);
                return carMapper.toResponseCarSave(car1,201,"Registro agregado al carro agregado exitosamente","201");
            }
            return carMapper.toResponseCarSave(null,201,"Registro agregado al carro agregado exitosamente","201");

        }catch (Exception e){
            return carMapper.toResponseCarSave(null, 400, e.toString(),
                    "400");
        }


    }

    @Override
    public ResponseCar listAll() {

        try {
            List<Car> cars = carRepository.findAll();
            return carMapper.toResponseCarDto(cars,200,"Lista Consultada con exito","200");
        }catch (Exception e){
            return ResponseCar.builder()
                    .codResponse(400)
                    .message(e.toString())
                    .status("400")
                    .build();
        }
    }

    @Override
    public List<Car> listByUser(Long idUser) {
        List<Car> cars = carRepository.findByIdUser(idUser);
        return cars;
    }
}
