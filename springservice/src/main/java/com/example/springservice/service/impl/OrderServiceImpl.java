package com.example.springservice.service.impl;

import com.example.springpublic.entity.Order;
import com.example.springservice.dao.OrderMapper;
import com.example.springservice.dao.OrderdetailDao;
import com.example.springservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author ：why
 * @description：TODO
 * @date ：2020/10/4 13:09
 */

@Service(value = "orderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;//这里会报错，但是并不会影响

    public OrderServiceImpl() {
        super();
    }

    @Override
    public int create(Order order) {
        return orderMapper.create(order);
    }

    @Override
    public Order queryByPk(String id) {
        return null;
    }

    @Override
    public long maxId() {
        return  orderMapper.maxId();
    }

    @Override
    public ArrayList<String> allPort() {
        return  orderMapper.allPort();
    }



    @Override
    public int updateByPk(Order order) {
        return 0;
    }

    @Override
    public int deleteByPk(String id) {
        return 0;
    }

    @Override
    public List<Order> queryByOrder(Order order) {
        return null;
    }

    @Override
    public List<Order> queryByPage(Map paramMap) {
        return null;
    }

    @Override
    public long countByCondtion(Map paramMap) {
        return 0;
    }


}
