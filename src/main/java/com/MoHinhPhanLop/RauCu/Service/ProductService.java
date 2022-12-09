package com.MoHinhPhanLop.RauCu.Service;
import com.MoHinhPhanLop.RauCu.Entity.Product;
import com.MoHinhPhanLop.RauCu.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> products(){
        return (List<Product>) productRepository.findAll();
    }
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
