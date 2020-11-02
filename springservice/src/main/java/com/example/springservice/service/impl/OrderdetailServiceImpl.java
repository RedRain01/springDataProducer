package com.example.springservice.service.impl;

import com.example.springpublic.entity.Orderdetail;
import com.example.springservice.dao.OrderdetailDao;
import com.example.springservice.service.OrderdetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service(value = "orderdetailService")
public class OrderdetailServiceImpl implements OrderdetailService {




    @Autowired
    private OrderdetailDao orderdetailDao;//这里会报错，但是并不会影响

    @Override
    public int create(Orderdetail orderdetail) {
        return orderdetailDao.create(orderdetail);
    }


    @Override
    public Orderdetail queryByPk(String orderid) {
        return null;
    }

    @Override
    public List<Orderdetail> all() {
        List<Orderdetail> all = orderdetailDao.all();
        return all;
    }

    @Override
    public int updateByPk(Orderdetail orderdetail) {
        return 0;
    }

    @Override
    public int deleteByPk(String orderid) {
        return 0;
    }

    @Override
    public List<Orderdetail> queryByOrderdetail(Orderdetail orderdetail) {
        return null;
    }

    @Override
    public List<Orderdetail> queryByPage(Map paramMap) {
        return null;
    }

    @Override
    public long countByCondtion(Map paramMap) {
        return 0;
    }
}

