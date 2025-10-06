package com.proyecto01.proyecto01.service;

import com.proyecto01.proyecto01.models.Customer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoustomerServiceImpl {

    List<Customer> customers = new ArrayList<>(Arrays.asList(
            new Customer(1, "Pablo" , "pnh0003", "123"),
            new Customer(2, "Pepe" , "jph0009", "123"),
            new Customer(3, "Juan" , "pyh0069", "123"),
            new Customer(4, "Jose" , "ong0002", "123")
    ));

}
