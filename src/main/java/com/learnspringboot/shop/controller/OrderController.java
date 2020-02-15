package com.learnspringboot.shop.controller;

import com.learnspringboot.shop.models.Order;
import com.learnspringboot.shop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author tamvo
 * @created 15/02/2020 - 2:58 PM
 */

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public ResponseEntity<Object> getOrders(){
        return new ResponseEntity<>(orderService.getOrders(), HttpStatus.OK);
    }

    @RequestMapping(value = "/orders", method = RequestMethod.POST)
    public ResponseEntity<String> createOrder(@RequestBody Order order){
        orderService.createOrder(order);
        return new ResponseEntity<>("Create order success", HttpStatus.OK);
    }

    @RequestMapping(value = "/orders/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteOrder(@PathVariable("id") long id){
        orderService.deleteOrder(id);
        return new ResponseEntity<>("Delete order success", HttpStatus.OK);
    }

    @RequestMapping(value = "/orders/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateOrder(@PathVariable("id") long id, @RequestBody Order order){
        orderService.updateOrder(order, id);
        return new ResponseEntity<>("Update order success", HttpStatus.OK);
    }
}
