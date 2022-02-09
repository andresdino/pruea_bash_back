package com.prueba_back.prueba_java.Mappers;

import com.prueba_back.prueba_java.Dto.ProductDto;
import com.prueba_back.prueba_java.Entity.Products;
import com.prueba_back.prueba_java.Response.ResponseProducSave;
import com.prueba_back.prueba_java.Response.ResponseProduct;
import com.prueba_back.prueba_java.Response.ResponseUserSave;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapper {
    public ResponseProduct toResponseProductDto(List<Products> products, Integer codeResponse, String message, String status){
        return ResponseProduct.builder()
                .message(message)
                .codResponse(codeResponse)
                .status(status)
                .productDto(toProduct(products))
                .build();
    }

    public List<ProductDto> toProduct(List<Products> products){
        if (products != null && !products.isEmpty()){
           return products.stream()
                   .map(this::toProductMap)
                   .collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    public ProductDto toProductMap(Products products){
        if (products != null){
            return ProductDto.builder()
                    .name(products.getName())
                    .value(products.getValue())
                    .weight(products.getWeight())
                    .quantity(products.getQuantity())
                    .build();
        }
        return null;
    }

    public ResponseProducSave toResponseProductSave(Products products, Integer codeResponse, String message, String status){
        return ResponseProducSave.builder()
                .codResponse(codeResponse)
                .message(message)
                .status(status)
                .productDto(toProductSave(products))
                .build();
    }

    public ProductDto toProductSave(Products products){
        ProductDto productDto = new ProductDto();

        if (products != null){
            productDto.name(products.getName());
            productDto.value(products.getValue());
            productDto.weight(products.getWeight());
            productDto.quantity(products.getQuantity());

            return productDto;
        }
        return null;
    }
}
