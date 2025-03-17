package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.demo.entity.User;
import com.example.demo.services.UserService;
import jakarta.servlet.http.HttpSession;

@Controller
public class UserRegistration {
	
	@Autowired
	UserService userservice;
	
//	@GetMapping("/register")
//	public String showregisrtation(Model model)
//	
//	{
//        model.addAttribute("user", new User());
//		return "UserRegistration";
//	}
	@GetMapping("/register")
	public String showregisrtation() {
	    return "UserRegistration";
	}
	@PostMapping("/post")
    public String registerUser(@ModelAttribute User user, Model model) {
        if (userservice.userExistsByEmail(user.getEmail())) {
            model.addAttribute("message", "Email already exists!");
            System.out.println("User already exist");
            return "ErrorReg";
        }
        userservice.adduser(user);
        model.addAttribute("message", "Registration successful!");
        return "redirect:/register";
    }
	
	
	@GetMapping("/getlogin")
    public String showLoginPage(Model model) {
        model.addAttribute("user", new User());
        return "Login";
    }

	
   
	@PostMapping("/login")
	public String loginUser(@ModelAttribute User user, Model model,HttpSession session) {
	    User existingUser = userservice.findByEmail(user.getEmail());
	    if (existingUser != null && existingUser.getPassword().equals(user.getPassword())) {
	        session.setAttribute("userEmail", existingUser.getEmail());
	        model.addAttribute("message", "Login successful!");
	        return "redirect:/GetInvoice";
	    } else {
	        model.addAttribute("error", "Invalid email or password");
	        return "UserRegistration";
	    }
	}
}
	








