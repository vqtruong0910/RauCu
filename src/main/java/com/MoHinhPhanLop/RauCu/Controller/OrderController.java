package com.MoHinhPhanLop.RauCu.Controller;

import com.MoHinhPhanLop.RauCu.Entity.Order;
import com.MoHinhPhanLop.RauCu.Entity.OrderDetail;
import com.MoHinhPhanLop.RauCu.Entity.User;
import com.MoHinhPhanLop.RauCu.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Controller
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/addOrder")
    public String addOrder(HttpSession session){
        Order order = new Order();
        Set<OrderDetail> orderDetails = new HashSet<>((ArrayList<OrderDetail> )session.getAttribute("cart"));
        order.setOrderDetails(orderDetails);
        orderService.addOrder(order);
        session.setAttribute("cart", null);
        return "redirect:/home";
    }
}
