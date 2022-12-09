package com.MoHinhPhanLop.RauCu.Service;

import com.MoHinhPhanLop.RauCu.Entity.Order;
import com.MoHinhPhanLop.RauCu.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    public Order addOrder(Order order){
        return orderRepository.save(order);
    }
}
