package com.proyecto01.proyecto01.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.proyecto01.proyecto01.models.Product;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service//("JSON")
@ConditionalOnProperty(name = "service.products", havingValue = "java")
//@Primary
public class ProductServiceJSONImpl implements ProductService {


    @Override
    public List<Product> getProducts() {
        List<Product> products;

        try{
            products = new ObjectMapper()
                    .readValue(this.getClass().getResourceAsStream("/products.json"),
                            new TypeReference<List<Product>>() {});
            return products;
        }catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }

}
