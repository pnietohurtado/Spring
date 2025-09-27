package com.udemy.udemy;

import com.udemy.udemy.model.Laptop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LaptopRepository {
    /*
    * En esta clase lo único de lo que nos vamos a encargar es de tener que
    * conectar nuestro programa con la base de datos
    * */

    public void save(Laptop l) {
        System.out.println("Laptop repository called, database conected!");
    }
}
