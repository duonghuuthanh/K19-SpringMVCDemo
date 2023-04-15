/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.service.impl;

import com.dht.repository.StatsRepository;
import com.dht.service.StatsService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class StatsServiceImpl implements StatsService {
    @Autowired
    private StatsRepository statsRepo;

    @Override
    public List<Object[]> statsCategory() {
        return this.statsRepo.statsCategory();
    }

    @Override
    public List<Object[]> statsRevenue(Date fromDate, Date toDate) {
        return this.statsRepo.statsRevenue(fromDate, toDate);
    }
    
}
