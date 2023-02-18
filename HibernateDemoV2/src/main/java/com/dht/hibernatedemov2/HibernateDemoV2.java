/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.dht.hibernatedemov2;

import com.dht.pojo.Category;
import com.dht.pojo.Product;
import com.dht.repository.ProductRepository;
import com.dht.repository.impl.ProductRepositoryImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import org.hibernate.Session;

/**
 *
 * @author admin
 */
public class HibernateDemoV2 {

    public static void main(String[] args) {
        ProductRepository p = new ProductRepositoryImpl();
        
        Map<String, String> params = new HashMap<>();
        params.put("kw", "iphone");
        
        List<Product> products = p.getProducts(params);
        products.forEach(r -> System.out.printf("%d - %s - %.1f\n", 
                r.getId(), r.getName(), r.getPrice()));
    }
}
