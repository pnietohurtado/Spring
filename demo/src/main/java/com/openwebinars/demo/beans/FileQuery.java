package com.openwebinars.demo.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;

@Component // LO convierte en bean
//@Primary // En caso de que haya varios BEAN asociados a una interfaz hay que darle prioridad a uno

public class FileQuery implements Query {
    @Value("${query.file.message}") // Declarado el valor de este mediante el "application.properties"
    private String mmessage;


    @Override
    public List<String> fetchData() {
        //return List.of("fetching", "data" , "from" , "file" );
        return List.of(mmessage);
    }
}
