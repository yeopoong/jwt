package com.example.repository;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.App;
import com.example.domain.Customer;

@RunWith(SpringRunner.class)
//@DataJpaTest
@SpringBootTest(classes=App.class)
public class CustomerServiceTest {

    @Autowired
    CustomerRepository customerRepository;
    
    @Test
    public void testGetCustomers() {
    	List<Customer> customers = customerRepository.findAll();
    	
    	assertThat(customers.size(), is(4));
    }
}
