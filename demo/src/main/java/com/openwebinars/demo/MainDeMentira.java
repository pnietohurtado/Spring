package com.openwebinars.demo;

import com.openwebinars.demo.autowired.MiServicio;
import com.openwebinars.demo.beans.Query;
import com.openwebinars.demo.scope.Servicio1;
import com.openwebinars.demo.scope.Servicio2;
import com.openwebinars.demo.scope.Servicio3;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
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

    /*
    @Autowired
    @Qualifier("DBQuery") // Hace innecesario el uso de la anotación @Primary
    private Query query;
*/
    @Autowired
    private Servicio1 servicio1;

    @Autowired
    private Servicio2 servicio2;

    @Autowired
    private Servicio3 servicio3;

    // @PostConstruct se ejecuta una vez que tiene declarada todas las dependencias
    @PostConstruct // Cuando Spring encuentre esto como un Bean, cuando se contruya ejecutará ese método
    public void init(){
        System.out.println("========Se inicia el proceso de nombre==========");
        for(String name : ctx.getBeanDefinitionNames()){
            System.out.println(">> " + name);
        }
        System.out.println("========Se termina el proceso de nombre==========");

        System.out.println(servicio1.utils);
        System.out.println(servicio2.utils);
        System.out.println(servicio3.utils);

        //miServicio.ejecutar();

        //System.out.println(query.fetchData());
    }

    @PreDestroy
    public void dispose(){
        System.out.println("Este Bean se va a eliminar!");
    }

}
