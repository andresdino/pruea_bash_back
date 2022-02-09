package com.prueba_back.prueba_java.Service.Impl;

import com.prueba_back.prueba_java.Dto.ProductDto;
import com.prueba_back.prueba_java.Entity.Kardex;
import com.prueba_back.prueba_java.Entity.Products;
import com.prueba_back.prueba_java.Mappers.ProductMapper;
import com.prueba_back.prueba_java.Repository.KardexRepository;
import com.prueba_back.prueba_java.Repository.ProductRepository;
import com.prueba_back.prueba_java.Response.ResponseCarSave;
import com.prueba_back.prueba_java.Response.ResponseProducSave;
import com.prueba_back.prueba_java.Response.ResponseProduct;
import com.prueba_back.prueba_java.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProductImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    KardexRepository kardexRepository;

    @Autowired
    ProductMapper productMapper;


    @Override
    public ResponseProducSave save(ProductDto productDto) {
        try {
            Products products = new Products();
            if (productDto != null){
                if (products.getId() != null){
                    Products productsUpdate = productRepository.findByIdProduc(productDto.id());

                    Long NewQuantity = productDto.quantity() + productsUpdate.getQuantity();

                    products.setId(productDto.id());
                    products.setName(productDto.name());
                    products.setValue(productDto.value());
                    products.setWeight(productDto.weight());
                    products.setQuantity(NewQuantity);
                    productRepository.save(products);
                    return productMapper.toResponseProductSave(products,201,"Producto Actualizado con éxito","201");
                }

                /* Kardex*/
                Kardex kardex = new Kardex();

                Float ValueTickets = productDto.value() * productDto.quantity();

                kardex.setName(productDto.name());
                kardex.setUnit(productDto.unit());
                kardex.setDate(new Date());
                kardex.setValue(productDto.value());
                kardex.setQuantityTickets(productDto.quantity());
                kardex.setValueTickets(ValueTickets);
                kardex.setQuantityBalance(productDto.quantity());
                kardex.setValueBalance(ValueTickets);
                kardexRepository.save(kardex);



                products.setName(productDto.name());
                products.setValue(productDto.value());
                products.setWeight(productDto.weight());
                products.setQuantity(productDto.quantity());
                productRepository.save(products);
                return productMapper.toResponseProductSave(products,201,"Producto registrado con éxito","201");
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
