package org.example.springdatajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    // 이름으로 조회
    List<Customer> findByName(@Param("name") String name);

    // 이메일로 조회
    List<Customer> findByEmail(@Param("email") String email);

    // 이메일에 특정 문자열을 포함하고 있는 고객 조회
    @Query("select c from Customer c where c.email LIKE %:email%")
    List<Customer> findByEmailNative(@Param("email") String email);

    // 각 고객과 고객의 주문 수를 조회
    @Query("select c, count(o) from Customer c left join c.orders o group by c")
    List<Object[]> findCustomerOrderCount();

    //고객의 각 세부 정보와 그들의 가장 최근 주문 조회
    @Query("select c  , o from Customer c join c.orders o where o.date = (select Max(o2.date) from Order o2 where o2.customer = c)")
    List<Object[] > findCustomersWithLatestOrder();

    //평균 나이보다 많은 고객 조회
    @Query("select c from Customer c where c.age>(select AVG(c2.age) from Customer c2)")
    List<Customer> findCustomerOlderThanAverage();
}
