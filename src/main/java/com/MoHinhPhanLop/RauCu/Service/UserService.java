package com.MoHinhPhanLop.RauCu.Service;

import com.MoHinhPhanLop.RauCu.Entity.User;
import com.MoHinhPhanLop.RauCu.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public List<User> listAll(){
        return (List<User>) userRepository.findAll();
    }
    public void save(User user){
        userRepository.save(user);
    }
    public User getByID(long id){
        return userRepository.findById(id).get();
    }
    public void delete(long id){
        userRepository.deleteById(id);
    }
    public static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
