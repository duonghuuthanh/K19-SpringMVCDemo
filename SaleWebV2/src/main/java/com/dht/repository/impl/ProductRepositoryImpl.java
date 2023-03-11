/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.repository.impl;

import com.dht.pojo.Product;
import com.dht.repository.ProductRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author admin
 */
@Repository
@Transactional
public class ProductRepositoryImpl implements ProductRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Product> getProducts(Map<String, String> params) {
        Session s = factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Product> q = b.createQuery(Product.class);
        Root root = q.from(Product.class);
        q.select(root);

        List<Predicate> predicates = new ArrayList<>();
        String kw = params.get("kw");
        if (kw != null && !kw.isEmpty()) {
            Predicate p = b.like(root.get("name").as(String.class),
                    String.format("%%%s%%", kw));
            predicates.add(p);
        }

        String fromPrice = params.get("fromPrice");
        if (fromPrice != null) {
            Predicate p = b.greaterThanOrEqualTo(root.get("price"), Double.parseDouble(fromPrice));
            predicates.add(p);
        }

        String toPrice = params.get("toPrice");
        if (toPrice != null) {
            Predicate p = b.lessThanOrEqualTo(root.get("price"), Double.parseDouble(toPrice));
            predicates.add(p);
        }
        
        String cateId = params.get("categoryId");
        if (cateId != null) {
            Predicate p = b.equal(root.get("categoryId"), Integer.parseInt(cateId));
            predicates.add(p);
        }

        q.where(predicates.toArray(Predicate[]::new));
        q.orderBy(b.desc(root.get("id")));

        Query query = s.createQuery(q);
        return query.getResultList();

    }
}
