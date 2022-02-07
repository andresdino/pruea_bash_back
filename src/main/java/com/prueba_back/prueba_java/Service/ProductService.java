package com.prueba_back.prueba_java.Service;

import com.prueba_back.prueba_java.Dto.ProductDto;
import com.prueba_back.prueba_java.Entity.Products;
import com.prueba_back.prueba_java.Response.ResponseProduct;

import java.util.List;

public interface ProductService {

    public Products save(Products productDto);

    public ResponseProduct listAll();

    public Products listById(Long id);

    public ProductDto update(Long id, ProductDto productDto);

}
