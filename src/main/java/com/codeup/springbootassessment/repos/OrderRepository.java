package com.codeup.springbootassessment.repos;

import com.codeup.springbootassessment.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.*;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findAllByOrderNumber (long orderNumber);
    Order findAllByEmail(String email);
    Order findAllByTotalPrice (double totalPrice);
}
