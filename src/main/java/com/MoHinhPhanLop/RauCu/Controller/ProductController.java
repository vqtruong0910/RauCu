package com.MoHinhPhanLop.RauCu.Controller;

import com.MoHinhPhanLop.RauCu.Entity.Order;
import com.MoHinhPhanLop.RauCu.Entity.OrderDetail;
import com.MoHinhPhanLop.RauCu.Entity.Product;
import com.MoHinhPhanLop.RauCu.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;

    @RequestMapping("/home")
    public String viewHome(Model model){
        List<Product> productLists = productService.listAll();
        model.addAttribute("listProducts",productLists);
        return "home";
    }

    @RequestMapping("/cart")
    public String viewCart(){
        return "cart";
    }
    @RequestMapping("/cart/{id}")
    public String cart(@PathVariable("id") Long id, HttpSession session){
        ArrayList<OrderDetail> cart = null;
        if(session.getAttribute("cart") == null){
            cart = new ArrayList<>();
            Product product = productService.find(id).get();
            OrderDetail orderDetail = new OrderDetail(product.getPrice(),product.getPrice(),1,product);
            cart.add(orderDetail);
            session.setAttribute("cart",cart);
        }
        else{
            cart = (ArrayList<OrderDetail>) session.getAttribute("cart");
            int index = this.exitst(id,cart);
            if(index == -1){
               Product product = productService.find(id).get();
                cart.add(new OrderDetail(product.getPrice(),product.getPrice(),1,product));
            }
            else{
                int quantity = cart.get(index).getQuantity() + 1;
                Double amount = cart.get(index).getPrice() * quantity;
                cart.get(index).setQuantity(quantity);
                cart.get(index).setAmount(amount);
            }
            session.setAttribute("cart",cart);
        }
        cart = (ArrayList<OrderDetail>) session.getAttribute("cart");
        for(int i = 0; i < cart.size(); i++){
            System.out.println(cart.get(i).getProduct().getId());
            System.out.println("Quantity:"+cart.get(i).getQuantity());
        }
        return "redirect:/cart";
    }

    private int exitst(Long id, ArrayList<OrderDetail> cart ){
        for(int i = 0; i < cart.size();i++){
            if(cart.get(i).getProduct().getId() == (id)){
                return i;
            }
        }
        return -1;
    }
    @RequestMapping("/cart/del/{id}")
    public String delProduct(@PathVariable("id") Long id, HttpSession session){
        if(session.getAttribute("cart") == null){

            return "redirect:/cart";
        }
        ArrayList<ArrayList> cart = new ArrayList<>();
        cart = (ArrayList<ArrayList>) session.getAttribute("cart");
        System.out.println(cart.get(Math.toIntExact(id)));
        cart.remove(Math.toIntExact(id));
        session.setAttribute("cart",cart);
        return "redirect:/cart";
    }
}
