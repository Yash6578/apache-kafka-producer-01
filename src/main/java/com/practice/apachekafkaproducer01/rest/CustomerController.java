package com.practice.apachekafkaproducer01.rest;

import com.practice.apachekafkaproducer01.constants.URLConstants;
import com.practice.apachekafkaproducer01.model.Customer;
import com.practice.apachekafkaproducer01.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(URLConstants.BASE_CUSTOMER_URL)
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/produce")
    ResponseEntity<String> produceToKafka(@RequestBody Customer customer) {

        String message = customerService.produceData(customer);

        return ResponseEntity.status(HttpStatus.OK).body(message);
    }

}
