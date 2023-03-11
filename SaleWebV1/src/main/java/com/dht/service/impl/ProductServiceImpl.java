/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.service.impl;

import com.dht.pojo.Product;
import com.dht.repository.ProductRepository;
import org.springframework.stereotype.Service;
import com.dht.service.ProductService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author admin
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getProducts(Map<String, String> params) {
        return this.productRepository.getProducts(params);
    }

}
