/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MoHinhPhanLop.RauCu.Controller;

import com.MoHinhPhanLop.RauCu.Entity.Category;
import com.MoHinhPhanLop.RauCu.Entity.Product;
import com.MoHinhPhanLop.RauCu.Entity.User;
import com.MoHinhPhanLop.RauCu.Service.CategoryService;
import com.MoHinhPhanLop.RauCu.Service.ProductService;
import com.MoHinhPhanLop.RauCu.Service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Admin
 */
@Controller
public class CategoryController {
    @Autowired
     private CategoryService categoryService;
    
    @Autowired
     private ProductService productService;

    @RequestMapping("/index")
    public String viewHomePage(Model model, @Param("keyword")String keyword) {
        List<Category> listCategory = categoryService.listAll();
        List<Product> listProduct = productService.listAll(keyword);
        List<Product> listSelling = productService.listAllSelling();
        model.addAttribute("listCategorys", listCategory);
        model.addAttribute("listProducts",listProduct);
        model.addAttribute("listSelling",listSelling);
//        model.addAttribute("keyword",keyword);
        return "index";
    }
    
    @RequestMapping("/index2")
    public String index2(Model model, @Param("keyword")String keyword) {
        List<Product> listProduct = productService.listAll(keyword);
        model.addAttribute("listProducts",listProduct);
        model.addAttribute("keyword",keyword);
        return "index2";
    }
    
    
    @RequestMapping("/index3")
    public String index3(Model model, @Param("keyword")String keyword) {
        List<Product> listProduct = productService.listAllCategory(keyword);
        model.addAttribute("listProducts",listProduct);
        model.addAttribute("keyword",keyword);
        return "index3";
    }
}
