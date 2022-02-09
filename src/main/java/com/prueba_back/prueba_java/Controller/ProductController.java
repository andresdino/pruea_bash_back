package com.prueba_back.prueba_java.Controller;

import com.prueba_back.prueba_java.Dto.ProductDto;
import com.prueba_back.prueba_java.Entity.Products;
import com.prueba_back.prueba_java.Response.ResponseCarSave;
import com.prueba_back.prueba_java.Response.ResponseProducSave;
import com.prueba_back.prueba_java.Response.ResponseProduct;
import com.prueba_back.prueba_java.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("products")
@CrossOrigin(origins = "*")
public class ProductController {
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/list")
    public ResponseEntity<ResponseProduct> ListProducts()throws IOException{
        return new ResponseEntity<ResponseProduct>(productService.listAll(),HttpStatus.OK) ;
    }

    @GetMapping(value = "/listBy/{id}")
    public Products productsById(@PathVariable Long id){

        return this.productService.listById(id);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<ResponseProducSave> productsSave(@RequestBody ProductDto productDto){

        return new ResponseEntity<ResponseProducSave>(productService.save(productDto),HttpStatus.CREATED);
    }

    @PutMapping(value = "/update")
    public ResponseEntity<ResponseProducSave> productsUpdate(@RequestBody ProductDto productDto){

        return new ResponseEntity<ResponseProducSave>(productService.save(productDto),HttpStatus.CREATED);
    }
}
