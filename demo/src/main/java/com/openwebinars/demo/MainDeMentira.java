package com.openwebinars.demo;

import com.openwebinars.demo.autowired.MiServicio;
import com.openwebinars.demo.beans.Query;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class MainDeMentira {

    @Autowired // Creamos una dependencia
    private ApplicationContext ctx;

    @Autowired
    private MiServicio miServicio;

    @Autowired
    @Qualifier("FileQuery")
    private Query query;

    @PostConstruct // Cuando Spring encuentre esto como un Bean, cuando se contruya ejecutará ese método
    public void init(){
        /*System.out.println("========Se inicia el proceso de nombre==========");
        for(String name : ctx.getBeanDefinitionNames()){
            System.out.println(">> " + name);
        }
        System.out.println("========Se termina el proceso de nombre==========");*/

        //miServicio.ejecutar();

        System.out.println(query.fetchData());
    }
}
