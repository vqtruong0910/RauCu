package com.MoHinhPhanLop.RauCu.Controller;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.MoHinhPhanLop.RauCu.Entity.User;
import com.MoHinhPhanLop.RauCu.Service.UserService;

@Controller
public class RegisterController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/register")
	public String registerPage() {
		return "register";
	}
	
	@PostMapping("/register")
	public String submitRegister(@ModelAttribute User user, Model model) throws NoSuchAlgorithmException {
		List<User> users = userService.listAll();
		String nameUser = user.getUserName();
		for (User us : users) {
			if(us.getUserName().equals(nameUser)) {
				model.addAttribute("content","Account already exists");
				return "register";
			}
		}
		String passwordUser = user.getPassword();
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		byte[] encodedhash = digest.digest(
				passwordUser.getBytes(StandardCharsets.UTF_8));
		String hashCode = UserService.bytesToHex(encodedhash);
		user.setPassword(hashCode);
		userService.save(user);
		return "redirect:/index";
	}
}
