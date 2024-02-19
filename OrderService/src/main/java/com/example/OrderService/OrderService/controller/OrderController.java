package com.example.OrderService.OrderService.controller;

import com.example.OrderService.OrderService.DTO.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sagardas on 18/02/24.
 */
@RestController
@RequestMapping("/order-service")
public class OrderController {
    public static final Logger LOGGER= LoggerFactory.getLogger(OrderController.class);
    ArrayList<Order> orderList=new ArrayList<>();
    @PostConstruct
    public void init(){
        Order order1=new Order("Laptop","electronic",1);
        Order order2=new Order("Mouse","electronic",2);
        Order order3=new Order("KeyBoard","electronic",3);
        Order order4=new Order("Wires","electronic",4);
        Order order5=new Order("CPU","electronic",5);

        orderList.add(order1);
        orderList.add(order2);
        orderList.add(order3);
        orderList.add(order4);
        orderList.add(order5);


    }
    @GetMapping("/order-list")
    public ResponseEntity<List<Order>> getOrderList(){
        return new ResponseEntity<>(orderList, HttpStatus.ACCEPTED);
    }

    @GetMapping("/order-detail/{name}")
    public ResponseEntity<Order> getOrderList(@PathVariable String name){
        for(Order order:orderList){
            if(order.getName().equalsIgnoreCase(name)){
                return new ResponseEntity<>(order,HttpStatus.ACCEPTED);
            }

        }
        return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
    }

    @PostMapping("/order-detail-payment")
    public ResponseEntity<String> orderPayment(@RequestBody Order object){
        LOGGER.info("In [order-service] [orderPayment()]");
        RestTemplate restTemplate=new RestTemplate();

        for(Order order:orderList){
            if(order.getName().equalsIgnoreCase(object.getName())){
               String response= restTemplate.getForObject("http://localhost:8090/payment-service/payment",String.class);
                return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
            }

        }
        return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
    }

    @GetMapping("/server")
    public String orderPayment(){
        LOGGER.info("In [order-service] [orderPayment()]");
        RestTemplate restTemplate=new RestTemplate();
        return restTemplate.getForObject("http://localhost:8090/payment-service/payment",String.class);

    }


}
