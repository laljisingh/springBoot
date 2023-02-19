package com.laljisingh.ecommerce.controller;

import com.laljisingh.ecommerce.dao.AddresRepository;
import com.laljisingh.ecommerce.dao.OrderRepository;
import com.laljisingh.ecommerce.dao.ProductRepository;
import com.laljisingh.ecommerce.dao.UserRepository;
import com.laljisingh.ecommerce.model.Address;
import com.laljisingh.ecommerce.model.Order;
import com.laljisingh.ecommerce.model.Product;
import com.laljisingh.ecommerce.model.User;
import com.laljisingh.ecommerce.service.OrderService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order/")
public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    UserRepository userRepository;

    @Autowired
    ProductRepository productRepository;
    @Autowired
    AddresRepository addresRepository;



    @PostMapping("add-Order")
    public Order addOrder(@RequestBody String newOrder){

        JSONObject json = new JSONObject(newOrder);
        Order order = setOrder(json);
        return orderRepository.save(order);

    }

    @GetMapping("get-orderBy-id/{orderId}")
    public Order getOrder(@PathVariable int orderId){
        return orderService.getOrderById(orderId);
    }

    private Order setOrder(JSONObject json) {

        Order order = new Order();

        String userId = json.getString("userId");
        User user = userRepository.findById(Integer.valueOf(userId)).get();
        order.setUserId(user);

        String productId = json.getString("productId");

        Product product = productRepository.findById(Integer.valueOf(productId)).get();
        order.setProductId(product);

        String addressid = json.getString("addressId");
        Address address = addresRepository.findById(Integer.valueOf(addressid)).get();
        order.setAddressId(address);

        order.setProductQuantity(json.getInt("productQuantity"));

        return order;


    }
}
