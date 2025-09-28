package com.proyecto01.proyecto01.controllers;

import com.proyecto01.proyecto01.models.Customer;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@RestController
public class CustomerRestController {

    private List<Customer> customers = new ArrayList<>(Arrays.asList(
            new Customer(1, "Pablo" , "pnh0003", "123"),
            new Customer(2, "Pepe" , "jph0009", "123"),
            new Customer(3, "Juan" , "pyh0069", "123"),
            new Customer(4, "Jose" , "ong0002", "123")
            ));

    @GetMapping("/customers")
    public List<Customer> getCustomers(){
        return customers;
    }

    @GetMapping("/customers/{name}")
    public Customer getCustomer(@PathVariable String name){
        Iterator it = customers.iterator();
        while(it.hasNext()){
            Customer c = (Customer) it.next();
            if(c.getName().equals(name)){
                return c;
            }
        }
        return null;
    }


    @PostMapping("/customers/u")
    public Customer postCustomer(@RequestBody Customer c){
        System.out.println("New customer added, Welcome " + c.getName() + "! ");
        customers.add(c);
        return c;
    }


    @PutMapping("/customer/lookFor")
    public Customer putCustomer(@RequestBody Customer c){
        Iterator<Customer> it = customers.iterator();
        while(it.hasNext()){
            Customer c1 = (Customer) it.next();
            if(c1.getId() == c.getId()){
                c1.setName(c.getName());
                c1.setUser_name(c.getUser_name());
                c1.setPass(c.getPass());
                return c1; 
            }
        }
        return c;
    }

}
