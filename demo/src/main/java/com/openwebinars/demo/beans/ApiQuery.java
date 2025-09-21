package com.openwebinars.demo.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ApiQuery implements Query {
    @Value("${query.api.message:Fetch data from external api}")
    private String message;


    @Override
    public List<String> fetchData() {
        return List.of(message );
    }
}
