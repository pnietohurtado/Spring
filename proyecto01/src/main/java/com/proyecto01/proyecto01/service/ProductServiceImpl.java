package com.proyecto01.proyecto01.service;

import com.proyecto01.proyecto01.models.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductServiceImpl
/*
* Aquí es donde debe de ir toda la lógica de nuestro programa
* , es decir, dentro de los controladores no puede haber métodos
* donde se declare o instancie clases o bucles donde se recorran los datos
* de todo eso se va a encargar la clase "Service"
* */
{

    List<Product> products = new ArrayList<>(Arrays.asList(
            new Product(1, "Patatas", 6.53, 100),
            new Product(2, "Patatas Fritas", 2.33, 50),
            new Product(3, "Zanahorias", 1.22, 30),
            new Product(4, "Arroz" , 0.66, 40)
    ));


    public List<Product> getProducts(){
        return products;
    }


}
