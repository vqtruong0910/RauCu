/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MoHinhPhanLop.RauCu.Service;

import com.MoHinhPhanLop.RauCu.Entity.Category;
import com.MoHinhPhanLop.RauCu.Entity.Product;
import com.MoHinhPhanLop.RauCu.Repository.CategoryRepository;
import com.MoHinhPhanLop.RauCu.Repository.ProductRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class ProductService {
    @Autowired
     private ProductRepository productRepository;
    public List<Product> listAll(String keyword){
        if(keyword!=null) {
            System.out.println(productRepository.search(keyword));
             return (List<Product>) productRepository.search(keyword);
        }
        return (List<Product>) productRepository.findAll();
    }
    
    public List<Product> listAllCategory(String keyword){
        if(keyword!=null){
            return (List<Product>) productRepository.searchCategory(keyword);
        } 
        return (List<Product>) productRepository.findAll();
    }
    
    public List<Product> listAllSelling() {
        System.out.println(productRepository.searchSelling());
        return (List<Product>) productRepository.searchSelling();
    }
    
    
    public void save(Product product){
        productRepository.save(product);
    }
    public Product get(long id){
        return productRepository.findById(id).get();
    }
    public void delete(long id){
        productRepository.deleteById(id);
    }
}
