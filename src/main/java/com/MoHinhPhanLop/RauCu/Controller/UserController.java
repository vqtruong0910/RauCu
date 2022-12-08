package com.MoHinhPhanLop.RauCu.Controller;

import com.MoHinhPhanLop.RauCu.Entity.Order;
import com.MoHinhPhanLop.RauCu.Entity.OrderDetail;
import com.MoHinhPhanLop.RauCu.Entity.User;
import com.MoHinhPhanLop.RauCu.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/listOrder")
    public String listOrderById(){
        Set<Order> orders = new HashSet<>();
        orders = userService.getByID(2).getOrders();
        System.out.println(Arrays.deepToString(orders.toArray()));
//        Iterator<Order> itr = orders.iterator();
//        while(itr.hasNext()){
//            Order order = itr.next();
//            System.out.println(order.getId());
//            List<OrderDetail> orderDetails = new ArrayList<>(order.getOrderDetails());
//            for(int i = 0; i<orderDetails.size();i++){
//                System.out.println(orderDetails.get(i).getProduct().getName());
//                System.out.println(orderDetails.get(i).getQuantity());
//            }
//        }
        return "redirect:/home";
    }
}
