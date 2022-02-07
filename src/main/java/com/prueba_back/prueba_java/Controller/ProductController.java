package com.prueba_back.prueba_java.Controller;

import com.prueba_back.prueba_java.Dto.ProductDto;
import com.prueba_back.prueba_java.Entity.Products;
import com.prueba_back.prueba_java.Service.Impl.ProductImpl;
import com.prueba_back.prueba_java.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

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
    public List<Products> ListProducts()throws IOException{
        return productService.listAll();
    }

    @GetMapping(value = "/listBy/{id}")
    public Products productsById(@PathVariable Long id){

        return this.productService.listById(id);
    }

    @PostMapping(value = "/save")
    public Products productsSave(@RequestBody Products productDto){
        return this.productService.save(productDto);
    }
}
