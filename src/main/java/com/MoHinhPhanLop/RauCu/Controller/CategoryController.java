/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MoHinhPhanLop.RauCu.Controller;

import com.MoHinhPhanLop.RauCu.Entity.Category;
import com.MoHinhPhanLop.RauCu.Entity.Product;
import com.MoHinhPhanLop.RauCu.Service.CategoryService;
import com.MoHinhPhanLop.RauCu.Service.ProductService;
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
    public String viewHomePage(Model model) {
        List<Category> listCategory = categoryService.listAll();
        List<Product> listProduct = productService.products();
        List<Product> listSelling = productService.listAllSelling();
        model.addAttribute("listCategorys", listCategory);
        model.addAttribute("listProducts",listProduct);
        model.addAttribute("listSelling",listSelling);
        return "index";
    }
    @RequestMapping("/danhmuc")
    public String danhmuc(Model model){
        List<Category> listCategory = categoryService.listAll();
        model.addAttribute("listCategorys", listCategory);
        return "danhmuc";
    }
    @RequestMapping("/timkiem")
    public String index2(Model model, @Param("keyword")String keyword) {
        List<Product> listProduct = productService.listAll(keyword);
        model.addAttribute("listProducts",listProduct);
        model.addAttribute("keyword",keyword);
        return "timkiem";
    }
    
    
    @RequestMapping("/sanphamdanhmuc")
    public String index3(Model model, @Param("keyword")String keyword) {
        List<Product> listProduct = productService.listAllCategory(keyword);
        model.addAttribute("listProducts",listProduct);
        model.addAttribute("keyword",keyword);
        return "sanphamdanhmuc";
    }
}
