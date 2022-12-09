package com.MoHinhPhanLop.RauCu.Controller;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.MoHinhPhanLop.RauCu.Entity.User;
import com.MoHinhPhanLop.RauCu.Service.UserService;


@Controller
public class LoginController {
	@Autowired
	private UserService userService;
	

	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}
	
	@PostMapping("/login")
	public String submitLogin(@ModelAttribute("user") User user,Model model, HttpSession session) throws NoSuchAlgorithmException {
		List<User> users = userService.listAll();
		String nameUser = user.getUserName();
		String passwordUser = user.getPassword();
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		byte[] encodedhash = digest.digest(
				passwordUser.getBytes(StandardCharsets.UTF_8));
		String hashCode = UserService.bytesToHex(encodedhash);
		for (User us : users) {
			if(us.getUserName().equals(nameUser) && us.getPassword().equals(hashCode)) {
				session.setAttribute("user", user);
				return "redirect:/index";
			}
		}
		model.addAttribute("message", "Account or password does not match");
		return "login";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		return "redirect:/login";
	}
}