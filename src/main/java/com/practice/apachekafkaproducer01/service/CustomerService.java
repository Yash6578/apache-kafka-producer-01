package com.practice.apachekafkaproducer01.service;

import com.practice.apachekafkaproducer01.constants.KafkaConstants;
import com.practice.apachekafkaproducer01.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    KafkaTemplate<String, Customer> kafkaTemplate;

    public String produceData(Customer customer) {
        kafkaTemplate.send(KafkaConstants.CUSTOMER_TOPIC, customer);
        System.out.println("Message Published" + customer);
        return "Produced Successfully";
    }
}
