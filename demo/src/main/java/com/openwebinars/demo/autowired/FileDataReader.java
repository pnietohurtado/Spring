package com.openwebinars.demo.autowired;

import org.springframework.stereotype.Component;

import java.util.List;

@Component //las interfaces no pueden ser BEAN
public class FileDataReader implements DataReader{
    @Override
    public List<String> readData() {
        return List.of("Dummy nsque");
    }
}
