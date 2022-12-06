/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MoHinhPhanLop.RauCu.Service;

import com.MoHinhPhanLop.RauCu.Entity.Category;
import com.MoHinhPhanLop.RauCu.Entity.User;
import com.MoHinhPhanLop.RauCu.Repository.CategoryRepository;
import com.MoHinhPhanLop.RauCu.Repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class CategoryService {
    @Autowired
     private CategoryRepository categoryRepository;
    public List<Category> listAll(){
        System.out.println(categoryRepository.findAll());
        return (List<Category>) categoryRepository.findAll();
    }
    public void save(Category category){
        categoryRepository.save(category);
    }
    public Category get(long id){
        return categoryRepository.findById(id).get();
    }
    public void delete(long id){
        categoryRepository.deleteById(id);
    }
}
