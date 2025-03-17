package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.demo.entity.Invoice;
import com.example.demo.entity.User;
import com.example.demo.services.InvoiceService;
import com.example.demo.services.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @Autowired
    private UserService userService;
    
    @PostMapping("/CreateInvoice")
    public String createInvoice(@ModelAttribute Invoice invoice, Model model, HttpSession session) {
        String userEmail = (String) session.getAttribute("userEmail");
        User user = userService.findByEmail(userEmail);
        if (user == null) {
            model.addAttribute("error", "User not found");
            return "Error";
        }

        invoice.setUser(user);
        invoiceService.addInvoice(invoice);
        model.addAttribute("message", "Invoice created successfully!");
        return "invoiceSuccess";
    }
    
    
    @GetMapping("/GetInvoice")
    public String showCreateInvoicePage(Model model, HttpSession session) {
        String userEmail = (String) session.getAttribute("userEmail");
        Invoice invoice = new Invoice();
        User user = new User();
        user.setEmail(userEmail);
        invoice.setUser(user);
        model.addAttribute("invoice", invoice);
        return "CreateInvoice";
    }
    
    
}