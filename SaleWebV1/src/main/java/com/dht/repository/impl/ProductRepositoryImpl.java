/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.repository.impl;

import com.dht.pojo.Cart;
import com.dht.pojo.OrderDetail;
import com.dht.pojo.Product;
import com.dht.pojo.SaleOrder;
import com.dht.repository.ProductRepository;
import com.dht.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.ws.rs.core.SecurityContext;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
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
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Product> getProducts(Map<String, String> params) {
        Session s = factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Product> q = b.createQuery(Product.class);
        Root root = q.from(Product.class);
        q.select(root);

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();
            String kw = params.get("kw");
            if (kw != null && !kw.isEmpty()) {
                Predicate p = b.like(root.get("name").as(String.class),
                        String.format("%%%s%%", kw));
                predicates.add(p);
            }

            String fromPrice = params.get("fromPrice");
            if (fromPrice != null && !fromPrice.isEmpty()) {
                Predicate p = b.greaterThanOrEqualTo(root.get("price").as(Double.class),
                        Double.parseDouble(fromPrice));
                predicates.add(p);
            }

            String toPrice = params.get("toPrice");
            if (toPrice != null && !toPrice.isEmpty()) {
                Predicate p = b.lessThanOrEqualTo(root.get("price").as(Double.class),
                        Double.parseDouble(toPrice));
                predicates.add(p);
            }

            String cateId = params.get("categoryId");
            if (cateId != null) {
                Predicate p = b.lessThanOrEqualTo(root.get("categoryId"), Integer.parseInt(cateId));
                predicates.add(p);
            }
            q.where(predicates.toArray(Predicate[]::new));
        }

        q.orderBy(b.desc(root.get("id")));
        Query query = s.createQuery(q);
        List<Product> products = query.getResultList();

        return products;
    }

    @Override
    public Product getProductById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Product.class, id);
    }

    @Override
    public boolean addOrUpdateProduct(Product p) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            if (p.getId() > 0)
                s.update(p);
            else
                s.save(p);
            
            return true;
        } catch (HibernateException ex) {
            return false;
        }
    }

    @Override
    public boolean deleteProduct(int id) {
        Product p = this.getProductById(id);
        Session s = this.factory.getObject().getCurrentSession();
        try {
            s.delete(p);
            return true;
        } catch (HibernateException ex) {
            return false;
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean addReceipt(Map<String, Cart> cart) {
        Session s = this.factory.getObject().getCurrentSession();
        
        try {
            SaleOrder r = new SaleOrder();
            r.setUserId(userRepository.getUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName()));
            s.save(r);

            for (Cart c: cart.values()) {
                OrderDetail d = new OrderDetail();
                d.setUnitPrice(c.getPrice());
                d.setNum(c.getQuantity());
                d.setOrderId(r);
                d.setProductId(this.getProductById(c.getId()));
                s.save(d);
            }
            return true;
        } catch (HibernateException ex) {
            return false;
        }
    }

}
