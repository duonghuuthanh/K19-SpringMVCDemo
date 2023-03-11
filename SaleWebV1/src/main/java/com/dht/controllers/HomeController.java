/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.controllers;

import com.dht.pojo.Category;
import com.dht.pojo.Product;
import com.dht.service.CategoryService;
import com.dht.service.ProductService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author admin
 */
@Controller
public class HomeController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @RequestMapping(path = "/")
    public String index(Model model, @RequestParam Map<String, String> params) {
        List<Category> cates = this.categoryService.getCategories();
        List<Product> products = this.productService.getProducts(params);

        model.addAttribute("categories", cates);
        model.addAttribute("products", products);
        
        return "index";
    }
}
