package com.trabajoTocho.TrabajoTocho;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.module.Configuration;

@SpringBootApplication
public class TrabajoTochoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrabajoTochoApplication.class, args);

        /*
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Session s = sessionFactory.openSession();
        s.beginTransaction();

        s.getTransaction().commit();
        s.close();
        */
	}

}
