package com.prueba_back.prueba_java.Service.Impl;

import com.prueba_back.prueba_java.Dto.ProductDto;
import com.prueba_back.prueba_java.Entity.Products;
import com.prueba_back.prueba_java.Mappers.ProductMapper;
import com.prueba_back.prueba_java.Repository.ProductRepository;
import com.prueba_back.prueba_java.Response.ResponseProduct;
import com.prueba_back.prueba_java.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductMapper productMapper;


    @Override
    public Products save(Products productDto) {
        if (productDto != null){
            Products products = productRepository.save(productDto);
            return products;
        }
        return null;
    }

    @Override
    public ResponseProduct listAll() {
            try{
                List<Products> productDto =  productRepository.findAll();
                return productMapper.toResponseProductDto(productDto,2001,"Consulta Exitosa","200");
            }catch (Exception e){
                return ResponseProduct.builder()
                        .codResponse(400)
                        .message(e.toString())
                        .status("400")
                        .build();
            }



    }

    @Override
    public Products listById(Long id) {
        if (id != null){
            Products products = productRepository.findByIdProduc(id);
            return products;
        }
        return null;
    }

    @Override
    public ProductDto update(Long id, ProductDto productDto) {
        return null;
    }
}
