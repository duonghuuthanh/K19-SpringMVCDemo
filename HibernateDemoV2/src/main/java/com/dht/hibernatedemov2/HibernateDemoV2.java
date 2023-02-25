/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.dht.hibernatedemov2;


import com.dht.pojo.Product;
import com.dht.repository.ProductRepository;
import com.dht.repository.StatsRepository;
import com.dht.repository.impl.ProductRepositoryImpl;
import com.dht.repository.impl.StatsRepositoryImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 *
 * @author admin
 */
public class HibernateDemoV2 {

    public static void main(String[] args) {
        ProductRepository p = new ProductRepositoryImpl();
        
        Map<String, String> params = new HashMap<>();
        params.put("kw", "iphone");
        params.put("fromPrice", "17000000");
        params.put("toPrice", "21000000");
        
        List<Product> products = p.getProducts(params);
        products.forEach(r -> System.out.printf("%d - %s - %,.1f\n", 
                r.getId(), r.getName(), r.getPrice()));
        
        System.out.println("=====================");
        StatsRepository s = new StatsRepositoryImpl();
        List<Object[]> resutls = s.statsCategory();
        for (Object[] x: resutls)
            System.out.printf("%s - %s: %s\n", x[0], x[1], x[2]);
        
        System.out.println("====================");
        List<Object[]> resutls2 = s.statsRevenue(null, null);
        for (Object[] x: resutls2)
            System.out.printf("%s - %s: %,.1f\n", x[0], x[1], Double.parseDouble(x[2].toString()));
    }
}
