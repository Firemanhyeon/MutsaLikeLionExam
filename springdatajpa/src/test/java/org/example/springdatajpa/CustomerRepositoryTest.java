package org.example.springdatajpa;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.jdbc.SqlGroup;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerRepositoryTest {
    private static final Logger log = LoggerFactory.getLogger(CustomerRepositoryTest.class);

    @Autowired
    CustomerRepository customerRepository;

    @Test
    void save(){

        Customer customer = new Customer("정호현" , "123@123" , 23);
        customerRepository.save(customer);
        System.out.println(customer.getId());
    }

    @Test
    void delete(){
        customerRepository.deleteById(1L);

    }

    @Test
    @DisplayName("g가포함된 사람이름")
    void select(){
        List<Customer> list =customerRepository.findByEmailNative("g");
        list.forEach(customer -> System.out.println(customer.getName()));
    }

    @Test
    void findCustomerOrderCount(){
        List<Object[]> customerOrderCount = customerRepository.findCustomerOrderCount();
        customerOrderCount.forEach(result->{
            Customer customer = (Customer) result[0];
            Long count = (Long) result[1];
            log.info("고객이름 : {} , 주문 수 : {}" , customer.getName() , count);
        });
    }

    @Test
    void findCustomerLastOrder(){
        List<Object[]> lastOrderCustomer = customerRepository.findCustomersWithLatestOrder();
        lastOrderCustomer.forEach(result -> {
            Customer customer = (Customer) result[0];
            Order order = (Order) result[1];
            log.info("고객: "+customer.getName()+"마지막주문 : "+ order.getProduct());
        });
    }

    @Test
    void findOlderThanAge(){
        List<Customer> findOlder = customerRepository.findCustomerOlderThanAverage();
        findOlder.forEach(result -> {
            log.info("평균나이보다 많은사람 : "+ result.getName() + "나이 : "+ result.getAge());
        });

    }
//    @Test
//    @SqlGroup({
//            @Sql(value = "classpath:db/test.sql",
//                    config = @SqlConfig(encoding = "utf-8", separator = ";", commentPrefix = "--"),
//                    executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
//    })
//    void test(){
//
//    }
}