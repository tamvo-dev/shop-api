package com.learnspringboot.shop.service;

import com.learnspringboot.shop.models.Order;
import com.learnspringboot.shop.models.Product;
import com.learnspringboot.shop.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @author tamvo
 * @created 15/02/2020 - 2:47 PM
 */

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public void createOrder(Order order){
        orderRepository.save(order);
    }

    public void deleteOrder(long id){
        orderRepository.deleteById(id);
    }

    public void updateOrder(Order order, long id){
        Order testOrder = orderRepository.findById(id).get();
        order.setId(id);
        orderRepository.save(order);
    }

    public Collection<Order> getOrders(){
        return orderRepository.findAll();
    }
}
