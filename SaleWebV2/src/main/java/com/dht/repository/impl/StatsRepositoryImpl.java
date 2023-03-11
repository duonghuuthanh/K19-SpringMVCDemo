///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package com.dht.repository.impl;
//
//import com.dht.pojo.Category;
//import com.dht.pojo.OrderDetail;
//import com.dht.pojo.Product;
//import com.dht.pojo.SaleOrder;
//import com.dht.repository.StatsRepository;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import javax.persistence.Query;
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Predicate;
//import javax.persistence.criteria.Root;
//import org.hibernate.Session;
//
///**
// *
// * @author admin
// */
//public class StatsRepositoryImpl implements StatsRepository {
//
//    @Override
//    public List<Object[]> statsCategory() {
//        try (Session session = HibernateUtils.getFactory().openSession()) {
//            CriteriaBuilder b = session.getCriteriaBuilder();
//            CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
//            
//            Root rP = q.from(Product.class);
//            Root rC = q.from(Category.class);
//           
//            q.where(b.equal(rP.get("category"), rC.get("id")));
//            
//            q.multiselect(rC.get("id"), rC.get("name"), b.count(rP.get("id")));
//            q.groupBy(rC.get("id"));
//            
//            Query query = session.createQuery(q);
//            return query.getResultList();
//        }
//    }
//
//    @Override
//    public List<Object[]> statsRevenue(Date fromDate, Date toDate) {
//        try (Session session = HibernateUtils.getFactory().openSession()) {
//            CriteriaBuilder b = session.getCriteriaBuilder();
//            CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
//            
//            Root rP = q.from(Product.class);
//            Root rD = q.from(OrderDetail.class);
//            Root rO = q.from(SaleOrder.class);
//            
//            List<Predicate> pres = new ArrayList<>();
//            pres.add(b.equal(rP.get("id"), rD.get("productId")));
//            pres.add( b.equal(rD.get("orderId"), rO.get("id")));
//            
//            q.multiselect(rP.get("id"), rP.get("name"), b.sum(b.prod(rD.get("num"), rD.get("unitPrice"))));
//            
//            if (fromDate != null)
//                pres.add(b.greaterThanOrEqualTo(rO.get("createdDate").as(Date.class), fromDate));
//            
//            if (toDate != null)
//                pres.add(b.lessThanOrEqualTo(rO.get("createdDate").as(Date.class), toDate));
//            
//            q.where(pres.toArray(Predicate[]::new));
//            q.groupBy(rD.get("id"));
//            
//            Query query = session.createQuery(q);
//            return query.getResultList();
//        }
//    }
//    
//}
