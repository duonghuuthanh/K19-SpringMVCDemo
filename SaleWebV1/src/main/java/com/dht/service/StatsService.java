/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dht.service;

import java.util.Date;
import java.util.List;

/**
 *
 * @author admin
 */
public interface StatsService {
    List<Object[]> statsCategory();

    List<Object[]> statsRevenue(Date fromDate, Date toDate);
}
