/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.controllers;

import com.dht.pojo.Comment;
import com.dht.pojo.User;
import com.dht.service.CommentService;
import com.dht.service.ProductService;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author admin
 */
@RestController
public class ApiComment {
    @Autowired
    private CommentService commentService;
    @Autowired
    private ProductService productService;
    
    @GetMapping("/products/{productId}/comments")
    public ResponseEntity<List<Comment>> getComments(@PathVariable(value = "productId") int id) {
        return new ResponseEntity<>(this.commentService.getComments(id), HttpStatus.OK);
    }
    
    @PostMapping(path = "/products/{productId}/comments", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<Comment> addComment(@PathVariable(value = "productId") int id,
            @RequestBody Map<String, String> params,
            HttpSession session) {
        Comment c = new Comment();
        c.setContent(params.get("content"));
        c.setProduct(this.productService.getProductById(id));
        c.setUser((User) session.getAttribute("currentUser"));
        c.setCreatedDate(new Date());
        
        if (this.commentService.addComment(c) == true)
            return new ResponseEntity<>(c, HttpStatus.CREATED);
        
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
