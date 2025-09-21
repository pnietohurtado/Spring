package com.openwebinars.demo.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MiServicio {

    //@Autowired
    private MiRepositorio miRepositorio;
    private DataUtils dataUtils;

    @Autowired
    private DataReader dataReader;

    /*
    public MiServicio(MiRepositorio miRepositorio){
        this.miRepositorio = miRepositorio;
    }
    */

    /*
    @Autowired // Se convierte en una inyección automática
    public void setMiRepositorio(MiRepositorio miRepositorio) {
        this.miRepositorio = miRepositorio;
    }
    */

    @Autowired
    public void prepare(MiRepositorio miRepositorio, DataUtils dataUtils) {
        this.miRepositorio = miRepositorio;
        this.dataUtils = dataUtils;
    }

    public void ejecutar() {
        miRepositorio.realizarOperacion();
        System.out.println(dataReader.readData());
    }


}
