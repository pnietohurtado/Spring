package com.openwebinars.demo.beans;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;

 // LO convierte en bean
//@Primary // En caso de que haya varios BEAN asociados a una interfaz hay que darle prioridad a uno
@Component
public class FileQuery implements Query {
    @Override
    public List<String> fetchData() {
        return List.of("fetching", "data" , "from" , "file" );
    }
}
