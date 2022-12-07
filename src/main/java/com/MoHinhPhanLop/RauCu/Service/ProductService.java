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
    ProductRepository productRepository;
    public List<Product> listAll(){
        System.out.println(productRepository.findAll());
        return (List<Product>) productRepository.findAll();
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
