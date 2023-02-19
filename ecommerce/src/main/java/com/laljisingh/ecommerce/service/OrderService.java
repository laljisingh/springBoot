package com.laljisingh.ecommerce.service;

import com.laljisingh.ecommerce.dao.OrderRepository;
import com.laljisingh.ecommerce.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;
    public String addOrder(Order newOrder) {
        orderRepository.save(newOrder);
        return "Order Saved";
    }

    public Order getOrderById(int id) {
        for (Order order : orderRepository.findAll()) {
            if(order.getOrderID()==id){
                return order;
            }
        }
        return null;
    }
}
