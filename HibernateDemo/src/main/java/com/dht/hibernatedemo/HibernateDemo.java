/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.dht.hibernatedemo;
import com.dht.pojo.Product;
import com.dht.repository.ProductRepository;
import com.dht.repository.StatsRepository;
import com.dht.repository.impl.ProductRepositoryImpl;
import com.dht.repository.impl.StatsRepositoryImpl;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 *
 * @author admin
 */
public class HibernateDemo {

    public static void main(String[] args) {
        ProductRepository p = new ProductRepositoryImpl();
        
        Map<String, String> params = new HashMap<>();
        params.put("kw", "iphone");
        params.put("fromPrice", "11000000");
        params.put("toPrice", "28000000");
        
        List<Product> products = p.getProducts(params);
        products.forEach(x -> System.out.printf("%d - %s - %d\n", 
                x.getId(), x.getName(), x.getPrice()));
        
        System.out.println("================");
        StatsRepository s = new StatsRepositoryImpl();
        List<Object[]> results = s.statsCategory();
        for (Object[] x: results)
            System.out.printf("%s - %s: %s\n", x[0], x[1], x[2]);
        
        
        System.out.println("==================");
        Date f = new Date(2020, 1, 4);
        Date t = new Date(2020, 1, 8);
        List<Object[]> revenues = s.statsRevenue(f, t);
        for (Object[] r: revenues)
            System.out.printf("%s - %s: %,.1f\n", r[0], r[1], Double.parseDouble(r[2].toString()));
    }
}
