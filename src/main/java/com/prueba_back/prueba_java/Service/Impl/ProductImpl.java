package com.prueba_back.prueba_java.Service.Impl;

import com.prueba_back.prueba_java.Dto.ProductDto;
import com.prueba_back.prueba_java.Entity.Products;
import com.prueba_back.prueba_java.Mappers.ProductMapper;
import com.prueba_back.prueba_java.Repository.ProductRepository;
import com.prueba_back.prueba_java.Response.ResponseCarSave;
import com.prueba_back.prueba_java.Response.ResponseProducSave;
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
    public ResponseProducSave save(ProductDto productDto) {
        try {
            Products products = new Products();
            if (productDto != null){
                products.setName(productDto.name());
                products.setValue(productDto.value());
                products.setWeight(productDto.weight());
                products.setQuantity(productDto.quantity());
                productRepository.save(products);
                return productMapper.toResponseProductSave(products,201,"Producto registrado con exito","201");
            }
            return null;
        }catch (Exception e){
            return null;
        }


    }

    @Override
    public ResponseProduct listAll() {
            try{
                List<Products> productDto =  productRepository.findAll();
                return productMapper.toResponseProductDto(productDto,200,"Consulta Exitosa","200");
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
