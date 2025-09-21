package com.openwebinars.demo.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;

//@Primary // En caso de que haya varios BEAN asociados a una interfaz hay que darle prioridad a uno
@Component // LO convierte en bean
public class DBQuery implements Query {
    @Value("${query.file.message}")
    private String mmessage;

    @Override
    public List<String> fetchData() {
        //return List.of("fetching", "data" , "from" , "database" );
        return List.of(mmessage);
    }
}
