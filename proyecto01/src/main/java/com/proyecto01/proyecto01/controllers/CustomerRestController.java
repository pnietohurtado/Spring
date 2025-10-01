package com.proyecto01.proyecto01.controllers;

import com.proyecto01.proyecto01.models.Customer;
import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerRestController {

    private List<Customer> customers = new ArrayList<>(Arrays.asList(
            new Customer(1, "Pablo" , "pnh0003", "123"),
            new Customer(2, "Pepe" , "jph0009", "123"),
            new Customer(3, "Juan" , "pyh0069", "123"),
            new Customer(4, "Jose" , "ong0002", "123")
            ));

    @GetMapping
    public ResponseEntity<List<Customer>> getCustomers(){
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> getCustomer(@PathVariable String name){
        Iterator it = customers.iterator();
        while(it.hasNext()){
            Customer c = (Customer) it.next();
            if(c.getName().equals(name)){
                return ResponseEntity.ok(c);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found by the username " + name);
    }

    //@RequestMapping(method = RequestMethod.POST)
    @PostMapping("/customers")
    public ResponseEntity<?> postCustomer(@RequestBody Customer c){
        System.out.println("New customer added, Welcome " + c.getName() + "! ");
        customers.add(c);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{username}")
                .buildAndExpand(c.getUser_name())
                .toUri();

        return ResponseEntity.created(location).build();

        /*
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Customer created succesfully by the username of " + c.getUser_name());
         */
    }


    @PutMapping("/customers")
    public ResponseEntity<?> putCustomer(@RequestBody Customer c){
        Iterator<Customer> it = customers.iterator();
        while(it.hasNext()){
            Customer c1 = (Customer) it.next();
            if(c1.getId() == c.getId()){
                c1.setName(c.getName());
                c1.setUser_name(c.getUser_name());
                c1.setPass(c.getPass());

                return ResponseEntity.noContent().build();

                /*
                return ResponseEntity.status(HttpStatus.NO_CONTENT)
                        .body("Customer succesfully found by the username of " + c.getUser_name());
                 */
            }
        }
        /*
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body("Customer not found by the username " + c.getUser_name());
         */
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/customers/delete/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable int id){
        Iterator<Customer> it = customers.iterator();
        while(it.hasNext()){
            Customer c1 = (Customer) it.next();
            if(c1.getId() == id){
                customers.remove(c1);
                return ResponseEntity.status(HttpStatus.ACCEPTED)
                        .body("Customer successfully deleted from the database");
            }
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body("Couldn't delete the customer " + id);
    }

    //@PatchMapping("/customers")
    @RequestMapping
    public ResponseEntity<?> patchCustomer(@RequestBody Customer customer){
        for(Customer c : customers){
            if(c.getId() == customer.getId()){
                if(customer.getName() != null){
                    c.setName(customer.getName());
                }else if(customer.getUser_name() != null){
                    c.setUser_name(customer.getUser_name());
                }else if(customer.getPass() != null){
                    c.setPass(customer.getPass());
                }
                return ResponseEntity.ok(c);
            }
        }

        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body("Customer not found by the username " + customer.getUser_name());
    }

}
