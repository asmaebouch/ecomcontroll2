package com.example.customerservice.controller;

import com.example.customerservice.configurations.ApplicationPropertiesConfiguration;
import com.example.customerservice.entities.Customer;
import com.example.customerservice.entities.CustomerProduct;
import com.example.customerservice.entities.Product;
import com.example.customerservice.repository.CustomerRepositor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class customerController {
    @Autowired
    private final ApplicationPropertiesConfiguration applicationPropertiesConfiguration;
    @Autowired
    CustomerRepositor customerRepositor;
    @Autowired
    RestTemplate restTemplate;


    public customerController(ApplicationPropertiesConfiguration applicationPropertiesConfiguration) {
        this.applicationPropertiesConfiguration = applicationPropertiesConfiguration;
    }
    @RequestMapping("/customers")
    public List<Customer> getCustomers(){
        List<Customer> customers =customerRepositor.findAll();
    List<Customer> limitCustomers = customers.subList(0,applicationPropertiesConfiguration.getLimitCustomers());
    return limitCustomers;
    }
    @RequestMapping("/getCustomerProducts/{id}")
        public CustomerProduct getCustomerProducts(@PathVariable("id") Long id){
            Optional<Customer> customer=customerRepositor.findById(id);
            Product product = restTemplate.getForObject("http://localhost:8888/INVENTORY-SERVICE/products/"+customer.get().getProductId()
                    ,Product.class);
            return new CustomerProduct(customer.get().getId(),customer.get().getName(),customer.get().getEmail(),product.getName(),product.getPrice());
        }
        @RequestMapping("/customers/{id}")
    public Optional<Customer> getCustomer(@PathVariable("id") Long id){
        return customerRepositor.findById(id);
        }
}
