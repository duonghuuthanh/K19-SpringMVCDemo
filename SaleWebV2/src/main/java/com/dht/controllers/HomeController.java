/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.controllers;

import com.dht.pojo.Category;
import com.dht.pojo.Product;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author admin
 */
@Controller
public class HomeController {
    @RequestMapping("/")
    public String index(Model model) {
        List<Category> cates = new ArrayList<>();
        cates.add(new Category(1, "Mobile"));
        cates.add(new Category(1, "Tablet"));
        cates.add(new Category(1, "Desktop"));
        
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "iPad Pro 2022", "https://res.cloudinary.com/dxxwcby8l/image/upload/v1647248652/dkeolz3ghc0eino87iec.jpg", 24000000l));
        products.add(new Product(1, "Galaxy Tab S8", "https://res.cloudinary.com/dxxwcby8l/image/upload/v1647248722/r8sjly3st7estapvj19u.jpg", 24000000l));
        products.add(new Product(1, "iPad Pro 2022", "https://res.cloudinary.com/dxxwcby8l/image/upload/v1647248652/dkeolz3ghc0eino87iec.jpg", 24000000l));
        products.add(new Product(1, "iPad Pro 2022", "https://res.cloudinary.com/dxxwcby8l/image/upload/v1647248722/r8sjly3st7estapvj19u.jpg", 24000000l));
        products.add(new Product(1, "iPad Pro 2022", "https://res.cloudinary.com/dxxwcby8l/image/upload/v1647248722/r8sjly3st7estapvj19u.jpg", 24000000l));
        
        model.addAttribute("categories", cates);
        model.addAttribute("products", products);
        return "index";
    }
}
